package com.example.havagas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        val telefoneCb = amb.telefoneCb
        val telefoneLl = amb.telefoneLl

        telefoneCb.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked) {
                telefoneLl.isVisible = true
            } else {
                telefoneLl.isVisible = false
            }
        }
    }
}