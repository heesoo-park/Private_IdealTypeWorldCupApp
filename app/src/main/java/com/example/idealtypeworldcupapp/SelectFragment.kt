package com.example.idealtypeworldcupapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class SelectFragment : Fragment() {
    private var currentRound: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currentRound = it.getInt(ARG_CURRENT_ROUND)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val roundText: TextView = view.findViewById(R.id.round_text)
        roundText.text = getString(R.string.round, currentRound + 1, (activity as? SelectActivity)?.getTotalRound())

        val leftImg: ImageView = view.findViewById(R.id.left_img)
        val rightImg: ImageView = view.findViewById(R.id.right_img)
        leftImg.setImageResource(R.drawable.pasta)
        rightImg.setImageResource(R.drawable.haejangguk)

        leftImg.setOnClickListener {
            (activity as? SelectActivity)?.moveToNextMatch()
        }

        rightImg.setOnClickListener {
            (activity as? SelectActivity)?.moveToNextMatch()
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun onPause() {
        super.onPause()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    companion object {
        private const val ARG_CURRENT_ROUND = "currentRound"

        fun newInstance(currentRound: Int): SelectFragment {
            val fragment = SelectFragment()
            val args = Bundle()
            args.putInt(ARG_CURRENT_ROUND, currentRound)
            fragment.arguments = args
            return fragment
        }
    }
}