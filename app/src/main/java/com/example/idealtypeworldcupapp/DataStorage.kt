package com.example.idealtypeworldcupapp

object DataStorage {
    private val imgs = listOf(
        R.drawable.haejangguk, R.drawable.pasta, R.drawable.bbane,
        R.drawable.boggeumbab, R.drawable.bossam, R.drawable.cake,
        R.drawable.donut, R.drawable.forkrib, R.drawable.friedchicken,
        R.drawable.goguma, R.drawable.hamburger, R.drawable.kimchijjigae,
        R.drawable.sandwich, R.drawable.tacoyakki, R.drawable.yakkisoba,
        R.drawable.zzimchicken)

    private var initialImg = mutableListOf<Int>()
    val selectedImg = mutableListOf<Int>()

    fun addImg(img: Int) {
        selectedImg.add(img)
    }

    fun getImg(index: Int): Int {
        return initialImg[index]
    }

    fun storeImg() {
        initialImg = selectedImg
        selectedImg.clear()
    }

    fun selectRandomImgs(n: Int) {
        initialImg = imgs.shuffled().take(n).toMutableList()
    }
}