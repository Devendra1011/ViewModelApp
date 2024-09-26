package com.example.viewmodelapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        // Initializing ViewModel
        // ViewModelProvider: creates and manage instances of ViewModels

        var counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        // set initial counter value in textview
        mainBinding.textViewCounter.text = counterViewModel.getCurrentCounter().toString()


        mainBinding.btnIncreaseCounter.setOnClickListener {

            counterViewModel.incrementCounter()
            mainBinding.textViewCounter.text = counterViewModel.getCurrentCounter().toString()
        }

    }
}