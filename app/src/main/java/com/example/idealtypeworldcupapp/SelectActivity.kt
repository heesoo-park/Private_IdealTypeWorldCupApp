package com.example.idealtypeworldcupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.idealtypeworldcupapp.databinding.ActivitySelectBinding

class SelectActivity : AppCompatActivity() {

    // ViewPager 선언
    private lateinit var viewPager: ViewPager2
    // 뷰 바인딩을 위한 변수
    private lateinit var binding: ActivitySelectBinding
    private var totalRound: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        totalRound = intent.getIntExtra("totalRound", 0)

        // 레이아웃에 있는 selectViewPager와 연결
        viewPager = binding.selectViewPager
        // viewPager와 fragment를 연결하기 위한 어댑터 설정
        viewPager.adapter = ViewPagerAdapter(this, totalRound)
        // 사용자가 맘대로 슬라이드할 수 없도록 설정
        viewPager.isUserInputEnabled = true
    }

    fun getTotalRound(): Int {
        return totalRound
    }
}