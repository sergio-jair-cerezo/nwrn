package com.sf.nwrn.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sf.nwrn.Activities.KotlinAndReactActivity
import com.sf.nwrn.Activities.ReactBaseActivity
import com.sf.nwrn.Bridging.ReactEmbededHelper

class ReactHighScoresFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val reactBaseActivity = activity as? ReactBaseActivity
        reactBaseActivity?.let { reactBaseActivity ->
            reactBaseActivity.mReactInstanceManager = ReactEmbededHelper.getReactInstanceManager(
                    reactBaseActivity.application)
            reactBaseActivity.mReactInstanceManager?.let { reactInstanceManager ->
                reactBaseActivity.mReactRootView = ReactEmbededHelper.getReactRootView(
                        reactBaseActivity, reactInstanceManager, null)
                reactBaseActivity.mReactRootView?.let { reactRootView ->
                    return reactRootView
                }
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPause() {
        val reactBaseActivity = activity as? ReactBaseActivity
        reactBaseActivity?.let { reactBaseActivity ->
            reactBaseActivity.mReactInstanceManager?.onHostPause(reactBaseActivity)
        }

        super.onPause()
    }

    override fun onResume() {
        super.onResume()

        val kotlinAndReactActivity = activity as KotlinAndReactActivity
        kotlinAndReactActivity?.actionBarDrawerToggle?.isDrawerIndicatorEnabled = false
        kotlinAndReactActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val reactBaseActivity = activity as? ReactBaseActivity
        reactBaseActivity?.let { reactBaseActivity ->
            reactBaseActivity.mReactInstanceManager?.onHostResume(reactBaseActivity)
        }
    }

    override fun onDestroy() {
        val reactBaseActivity = activity as? ReactBaseActivity
        reactBaseActivity?.let { reactBaseActivity ->
            reactBaseActivity.mReactInstanceManager?.onHostDestroy(reactBaseActivity)
            reactBaseActivity.mReactRootView?.unmountReactApplication()

            reactBaseActivity.mReactInstanceManager = null
            reactBaseActivity.mReactRootView = null
        }
        super.onDestroy()
    }
}