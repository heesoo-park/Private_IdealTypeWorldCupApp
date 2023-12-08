package com.example.idealtypeworldcupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.idealtypeworldcupapp.DataStorage.storeImg
import com.example.idealtypeworldcupapp.databinding.ActivitySelectBinding

// 선택 화면
class SelectActivity : AppCompatActivity() {

    // ViewPager 선언
    private lateinit var viewPager: ViewPager2
    // 뷰 바인딩을 위한 변수
    private lateinit var binding: ActivitySelectBinding
    // 총 라운드를 저장하는 변수
    private var totalRound: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 시작화면에서(or 이전 라운드에서) 넘겨준 값 받기
        totalRound = intent.getIntExtra("totalRound", 0)

        // 레이아웃에 있는 selectViewPager와 연결
        viewPager = binding.selectViewPager
        // viewPager와 fragment를 연결하기 위한 어댑터 설정
        viewPager.adapter = ViewPagerAdapter(this, totalRound / 2)
        // 사용자가 맘대로 슬라이드할 수 없도록 설정
        viewPager.isUserInputEnabled = false
    }

    // 다음 페이지로 전환하는 함수
    fun moveToNextMatch() {
        // 마지막 페이지인가
        if (viewPager.currentItem == totalRound / 2 - 1) {
            storeImg()
            // 결승인가
            if (totalRound == 2) {
                // 결과 화면으로 이동
                val intent = Intent(this@SelectActivity, ResultActivity::class.java)
                startActivity(intent)
            } else {
                // 16강 -> 8강 -> 4강 -> 결승
                val intent = Intent(this@SelectActivity, SelectActivity::class.java)
                intent.putExtra("totalRound", totalRound / 2)
                startActivity(intent)
            }
            finish()
        } else {
            // 다음 페이지로 이동
            val nextMatch = viewPager.currentItem + 1
            if (nextMatch < (viewPager.adapter?.itemCount ?: 0)) {
                viewPager.setCurrentItem(nextMatch, true)
            }
        }
    }

    // 프래그먼트에서 현재 라운드를 알 수 있도록 만들어둔 함수
    fun getCurrentRound(): Int {
        return totalRound
    }

    // 프래그먼트에서 총 매치를 알 수 있도록 만들어둔 함수
    fun getTotalMatch(): Int {
        return totalRound / 2
    }
}