package com.sf.nwrn.Bridging

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.shell.MainReactPackage
import com.sf.nwrn.BuildConfig

class ReactEmbededHelper {
    companion object {
        fun getReactInstanceManager(application: Application): ReactInstanceManager {
            val reactInstanceManager = ReactInstanceManager.builder()
                    .setApplication(application)
                    .setBundleAssetName("index.android.bundle")
                    .setJSMainModulePath("index")
                    .addPackage(MainReactPackage())
                    .addPackage(NavigationExternalPackage())
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    .build()
            return reactInstanceManager
        }

        fun getReactRootView(context: Context, reactInstanceManager: ReactInstanceManager,
                             initialProperties: Bundle?): ReactRootView {
            var reactRootView = ReactRootView(context)


            // The string here (e.g. "MyReactNativeApp") has to match
            // the string in AppRegistry.registerComponent() in index.js
            reactRootView?.startReactApplication(reactInstanceManager, "nwrn", initialProperties)

            reactRootView?.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)
            return reactRootView
        }
    }
}