package com.example.idealtypeworldcupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.idealtypeworldcupapp.DataStorage.selectRandomImgs
import com.example.idealtypeworldcupapp.databinding.ActivityMainBinding

// 시작 화면
class MainActivity : AppCompatActivity() {
    // 뷰바인딩 변수
    private lateinit var binding: ActivityMainBinding
    // 총 라운드 수
    private var round: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 라디오버튼 그룹 값 변화 체크 리스너
        binding.roundRadioGroup.setOnCheckedChangeListener { _, i ->
            when (i) {
                binding.firstRadioBtn.id -> round = 4
                binding.secondRadioBtn.id -> round = 8
                binding.thirdRadioBtn.id -> round = 16
            }
        }

        // 시작 버튼 클릭 이벤트
        binding.startBtn.setOnClickListener {
            // 라디오버튼이 클릭되었는지 체크
            if (binding.roundRadioGroup.checkedRadioButtonId != -1) {
                // 라운드에 필요한 이미지들을 랜덤으로 선택
                round?.let { info -> selectRandomImgs(info) }
                // 선택 화면으로 이동
                val intent = Intent(this@MainActivity, SelectActivity::class.java)
                // 화면을 구성할 때 필요한 라운드 변수 넘김
                intent.putExtra("totalRound", round)
                startActivity(intent)
            } else {
                Toast.makeText(this, "라운드 수를 체크해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}