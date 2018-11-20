package com.sf.nwrn.Bridging

import android.support.v4.view.GravityCompat
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.sf.nwrn.Activities.ReactBaseActivity

class NavigationExternalManager(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "NavigationExternalManager"
    }

    @ReactMethod
    fun openMenuFromJS() {
        val baseActivity = reactApplicationContext.currentActivity as? ReactBaseActivity
        baseActivity?.getDrawerLayout()?.openDrawer(GravityCompat.START)
    }

    @ReactMethod
    fun showHighScoresResultFromJS(scoresDisplayed: Int) {
        Log.d("NEM", "scoresDisplayed: $scoresDisplayed")
    }
}