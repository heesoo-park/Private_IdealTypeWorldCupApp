package com.example.idealtypeworldcupapp

import android.util.Log

// 이상형 월드컵에서 쓰이는 이미지들을 모아두고, 저장하고, 선택하는 클래스
object DataStorage {
    // 전체 이미지 리스트
    private val imgs = listOf(
        R.drawable.haejangguk, R.drawable.pasta, R.drawable.bbane,
        R.drawable.boggeumbab, R.drawable.bossam, R.drawable.cake,
        R.drawable.donut, R.drawable.forkrib, R.drawable.friedchicken,
        R.drawable.goguma, R.drawable.hamburger, R.drawable.kimchijjigae,
        R.drawable.sandwich, R.drawable.tacoyakki, R.drawable.yakkisoba,
        R.drawable.zzimchicken)

    // 라운드에 사용되는 초기 이미지 리스트
    private var initialImg = mutableListOf<Int>()
    // 사용자의 선택을 받은 이미지 리스트
    var selectedImg = mutableListOf<Int>()

    // 사용자의 선택을 받은 이미지를 리스트에 추가
    fun addImg(img: Int) {
        selectedImg.add(img)
    }

    // 매치에 사용될 이미지를 불러오거나 addImg 함수를 사용할 때 사용한 함수
    fun getImg(index: Int): Int {
        return initialImg[index]
    }

    // 선택된 이미지 리스트를 다음 라운드를 위해 초기 이미지 리스트에 저장하는 함수
    fun storeImg() {
        initialImg = selectedImg.shuffled().toMutableList()
        selectedImg = mutableListOf()
    }

    // 랜덤으로 라운드에 맞는 개수의 이미지를 뽑아주는 함수
    fun selectRandomImgs(n: Int) {
        initialImg = imgs.shuffled().take(n).toMutableList()
    }
}