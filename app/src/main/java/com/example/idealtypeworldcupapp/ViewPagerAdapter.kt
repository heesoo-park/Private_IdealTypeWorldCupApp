package com.example.idealtypeworldcupapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// 어댑터(뷰페이저 - 프래그먼트)
class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val match: Int): FragmentStateAdapter(fragmentActivity) {
    // 생성할 총 프래그먼트 수
    override fun getItemCount(): Int {
        return match
    }

    // 프래그먼트를 만드는 함수
    override fun createFragment(position: Int): Fragment {
        return SelectFragment.newInstance(position)
    }
}