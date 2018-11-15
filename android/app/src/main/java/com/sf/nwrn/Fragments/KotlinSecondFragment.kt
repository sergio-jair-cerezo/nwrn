package com.sf.nwrn.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sf.nwrn.Activities.KotlinActivity
import com.sf.nwrn.R

class KotlinSecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kotlin_second, container, false)
    }

    override fun onResume() {
        super.onResume()

        val kotlinActivity = activity as KotlinActivity
        kotlinActivity?.actionBarDrawerToggle?.isDrawerIndicatorEnabled = false
        kotlinActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}