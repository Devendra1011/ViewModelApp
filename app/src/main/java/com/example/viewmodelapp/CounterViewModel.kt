package com.example.viewmodelapp

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var counter: Int = 0


    fun incrementCounter() {
        counter++
    }

    fun getCurrentCounter(): Int {
        return counter
    }

}