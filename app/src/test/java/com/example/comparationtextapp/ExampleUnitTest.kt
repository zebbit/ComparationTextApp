package com.example.comparationtextapp

import com.example.comparationtextapp.view.MainActivity
import com.example.comparationtextapp.view.MainViewModel
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.manipulation.Ordering.Context

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainActivity: MainActivity

    @Before
    fun setup() {
        mainViewModel = MainViewModel()
        mainActivity = MainActivity()
        val context = mainActivity
    }

    @Test
    fun mainViewModelCheckInitialValue() {
        val value = mainViewModel.textResponse.value?.resultCompare
        assertEquals("-", value)
    }
}