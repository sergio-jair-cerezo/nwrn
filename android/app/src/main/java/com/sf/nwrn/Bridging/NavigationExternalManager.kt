package com.sf.nwrn.Bridging

import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.sf.nwrn.Activities.ReactBaseActivity
import com.sf.nwrn.Fragments.ReactHighScoresResultFragment
import com.sf.nwrn.R

class NavigationExternalManager(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "NavigationExternalManager"
    }

    @ReactMethod
    fun openMenuFromJS() {
        val reactBaseActivity = reactApplicationContext.currentActivity as? ReactBaseActivity
        reactBaseActivity?.getDrawerLayout()?.openDrawer(GravityCompat.START)
    }

    @ReactMethod
    fun showHighScoresResultFromJS(scoresDisplayed: Int) {
        val reactBaseActivity = reactApplicationContext.currentActivity as? ReactBaseActivity
        var transaction = reactBaseActivity?.supportFragmentManager?.beginTransaction()
        //transaction?.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        val reactHighScoresResultFragment = ReactHighScoresResultFragment()
        reactHighScoresResultFragment.resultsDisplayed = scoresDisplayed
        transaction?.replace(R.id.fragment_container, reactHighScoresResultFragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}