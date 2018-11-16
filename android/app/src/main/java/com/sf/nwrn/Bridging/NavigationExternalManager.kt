package com.sf.nwrn.Bridging

import android.support.v4.view.GravityCompat
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.sf.nwrn.Activities.BaseActivity

class NavigationExternalManager(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "NavigationExternalManager"
    }

    @ReactMethod
    fun openMenuFromJS() {
        val baseActivity = reactApplicationContext.currentActivity as? BaseActivity
        baseActivity?.getDrawerLayout()?.openDrawer(GravityCompat.START)
    }
}