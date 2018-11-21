package com.sf.nwrn.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sf.nwrn.R
import kotlinx.android.synthetic.main.fragment_react_high_scores_result.*


class ReactHighScoresResultFragment : Fragment() {

    var resultsDisplayed: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_react_high_scores_result, container, false)
    }

    override fun onStart() {
        super.onStart()

        tv_results.text = "$resultsDisplayed scores were displayed"

        btn_done.setOnClickListener {
            val fragmentManager = fragmentManager
            while (fragmentManager?.backStackEntryCount ?: 0 > 0) {
                fragmentManager?.popBackStackImmediate()
            }
        }
    }
}
