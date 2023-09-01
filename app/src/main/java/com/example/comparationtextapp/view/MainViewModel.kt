package com.example.comparationtextapp.view

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comparationtextapp.R
import com.example.comparationtextapp.model.TextResponse
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private var _textResponse = MutableLiveData(TextResponse("-"))
    val textResponse: LiveData<TextResponse> get() = _textResponse

    fun compareTexts(textOne: String, textTwo: String, context: Context) {
        if(textOne.isNotEmpty() && textTwo.isNotEmpty()) {
            if(textOne.equals(textTwo))
                updateResponse("Los textos son iguales")
            else
                updateResponse("Los textos son distintos")
        } else {
            Toast.makeText(context, R.string.toast_msg, Toast.LENGTH_LONG).show()
        }
    }

    fun updateResponse(newTextResponse: String) {
        viewModelScope.launch{
            _textResponse.value = TextResponse(newTextResponse)
        }
    }
}