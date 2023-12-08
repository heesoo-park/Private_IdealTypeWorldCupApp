package com.example.idealtypeworldcupapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.idealtypeworldcupapp.DataStorage.addImg
import com.example.idealtypeworldcupapp.DataStorage.getImg

// 선택 화면 페이지
class SelectFragment : Fragment() {
    // 현재 라운드
    private var currentMatch: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 프래그먼트 초기화할 때 넘어온 값 저장
        arguments?.let {
            currentMatch = it.getInt(ARG_CURRENT_MATCH)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 레이아웃은 fragment_select 사용
        return inflater.inflate(R.layout.fragment_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 현재 라운드를 알려주는 TextView
        val roundText: TextView = view.findViewById(R.id.selectTitle_text)
        val currentRound = (activity as? SelectActivity)?.getCurrentRound()
        roundText.text = if (currentRound == 2) "음식 이상형 월드컵 결승" else "음식 이상형 월드컵 ${currentRound}강"

        // 몇 번째 매치인지 출력해주는 TextView
        val matchText: TextView = view.findViewById(R.id.match_text)
        matchText.text = getString(R.string.match, currentMatch + 1, (activity as? SelectActivity)?.getTotalMatch())

        // 좌우 이미지(선택지)
        val leftImg: ImageView = view.findViewById(R.id.left_img)
        val rightImg: ImageView = view.findViewById(R.id.right_img)
        // DataStorage의 getImg를 통해 이미지를 가져옴
        leftImg.setImageResource(getImg(currentMatch * 2))
        rightImg.setImageResource(getImg(currentMatch * 2 + 1))

        // 왼쪽 이미지 클릭 이벤트
        leftImg.setOnClickListener {
            addImg(getImg(currentMatch * 2))
            (activity as? SelectActivity)?.moveToNextMatch()
        }
        // 오른쪽 이미지 클릭 이벤트
        rightImg.setOnClickListener {
            addImg(getImg(currentMatch * 2 + 1))
            (activity as? SelectActivity)?.moveToNextMatch()
        }
    }

    // 가로 모드 유지
    override fun onResume() {
        super.onResume()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    // 가로 모드 유지
    override fun onPause() {
        super.onPause()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    // 생성 및 초기화를 위한 companion object
    companion object {
        private const val ARG_CURRENT_MATCH = "currentRound"
        // 새로운 프래그먼트 인스턴스를 만드는 함수
        fun newInstance(currentRound: Int): SelectFragment {
            val fragment = SelectFragment()
            val args = Bundle()
            args.putInt(ARG_CURRENT_MATCH, currentRound)
            fragment.arguments = args
            return fragment
        }
    }
}