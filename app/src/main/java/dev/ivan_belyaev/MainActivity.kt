package dev.ivan_belyaev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.ivan_belyaev.vkproductsapp.databinding.ActivityMainBinding

internal class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}