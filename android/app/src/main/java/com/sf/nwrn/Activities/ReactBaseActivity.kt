package com.sf.nwrn.Activities

import android.view.KeyEvent
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler

abstract class ReactBaseActivity : BaseActivity(), DefaultHardwareBackBtnHandler {

    protected var mReactRootView: ReactRootView? = null
    protected var mReactInstanceManager: ReactInstanceManager? = null

    override fun onPause() {
        super.onPause()

        mReactInstanceManager?.onHostPause(this)
    }

    override fun onResume() {
        super.onResume()

        mReactInstanceManager?.onHostResume(this, this)
    }

    override fun onDestroy() {
        super.onDestroy()

        mReactInstanceManager?.onHostDestroy(this)
        mReactRootView?.unmountReactApplication()
    }

    override fun onBackPressed() {
        mReactInstanceManager?.let {
            it.onBackPressed()
        } ?: run {
            super.onBackPressed()
        }
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager?.showDevOptionsDialog()
            return true
        }
        return super.onKeyUp(keyCode, event)
    }
}