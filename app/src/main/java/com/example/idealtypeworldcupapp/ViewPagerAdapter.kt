package com.example.idealtypeworldcupapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val round: Int): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return round
    }

    override fun createFragment(position: Int): Fragment {
        return SelectFragment.newInstance(position)
    }
}