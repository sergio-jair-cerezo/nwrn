package com.sf.nwrn.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sf.nwrn.Activities.KotlinAndReactActivity
import com.sf.nwrn.R
import kotlinx.android.synthetic.main.fragment_kotlin_to_react.*

class KotlinToReactFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kotlin_to_react, container, false)
    }

    override fun onStart() {
        super.onStart()

        val initialProperties = Bundle()
        val scoresArray = ArrayList<Bundle>()
        val alexBundle = Bundle()
        alexBundle.putString("name", "Alex")
        alexBundle.putString("value", "42")
        scoresArray.add(alexBundle)
        val joelBundle = Bundle()
        joelBundle.putString("name", "Joel")
        joelBundle.putString("value", "10")
        scoresArray.add(joelBundle)
        initialProperties.putParcelableArrayList("scores", scoresArray)

        btn_go_to_rn.setOnClickListener {
            var transaction = fragmentManager?.beginTransaction()
            //transaction?.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
            val reactHighScoresFragment = ReactHighScoresFragment()
            reactHighScoresFragment.initialProperties = initialProperties
            transaction?.replace(R.id.fragment_container, reactHighScoresFragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }

    override fun onResume() {
        super.onResume()

        val kotlinAndReactActivity = activity as KotlinAndReactActivity
        kotlinAndReactActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        kotlinAndReactActivity?.actionBarDrawerToggle?.isDrawerIndicatorEnabled = true
    }
}