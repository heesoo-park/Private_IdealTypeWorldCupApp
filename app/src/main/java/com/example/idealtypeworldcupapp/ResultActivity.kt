package com.example.idealtypeworldcupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.idealtypeworldcupapp.DataStorage.getImg
import com.example.idealtypeworldcupapp.databinding.ActivityResultBinding

// 결과 화면
class ResultActivity : AppCompatActivity() {
    // 뷰 바인딩을 위한 변수
    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1등한 이미지 세팅
        binding.resultImg.setImageResource(getImg(0))

        // 다시하기 버튼 클릭 이벤트
        binding.retryBtn.setOnClickListener {
            // 시작 화면으로 이동
            var intent = Intent(this@ResultActivity, MainActivity::class.java)
            // 중간에 사용했던 액티비티의 내용을 지우고 새로 시작
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}