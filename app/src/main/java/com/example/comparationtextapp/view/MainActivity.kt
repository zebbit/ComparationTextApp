package com.example.comparationtextapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import com.example.comparationtextapp.R
import com.example.comparationtextapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context = applicationContext

        val firstText = findViewById(R.id.txt_one) as EditText
        val secondText = findViewById(R.id.txt_two) as EditText

        mainViewModel.textResponse.observe(this) {
            binding.txtResult.text = it.resultCompare
        }

        binding.btnCompare.setOnClickListener {
            mainViewModel.compareTexts(firstText.text.toString(), secondText.text.toString(), context)
        }
    }
}