package com.example.idealtypeworldcupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.idealtypeworldcupapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var round: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.roundRadioGroup.setOnCheckedChangeListener { _, i ->
            when (i) {
                binding.firstRadioBtn.id -> round = 4
                binding.secondRadioBtn.id -> round = 8
                binding.thirdRadioBtn.id -> round = 16
            }
        }
        binding.startBtn.setOnClickListener {
            if (binding.roundRadioGroup.checkedRadioButtonId != -1) {
                val intent = Intent(this@MainActivity, SelectActivity::class.java)
                intent.putExtra("totalRound", round)
                startActivity(intent)
            } else {
                Toast.makeText(this, "라운드 수를 체크해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}