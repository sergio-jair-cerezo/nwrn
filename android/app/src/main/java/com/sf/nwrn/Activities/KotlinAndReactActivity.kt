package com.sf.nwrn.Activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.sf.nwrn.R
import com.sf.nwrn.Fragments.KotlinToReactFragment
import kotlinx.android.synthetic.main.activity_kotlin_and_react.*
import kotlinx.android.synthetic.main.app_bar_kotlin_and_react.*

class KotlinAndReactActivity : BaseActivity() {

    //private var mReactRootView: ReactRootView? = null
    //private var mReactInstanceManager: ReactInstanceManager? = null
    var actionBarDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_kotlin_and_react)
        setSupportActionBar(toolbar)

        val actionBarDrawerToggle = ActionBarDrawerToggle(this, getDrawerLayout(), toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()

        actionBarDrawerToggle!!.setToolbarNavigationClickListener {
            onBackPressed()
        }

        getNavigationView()?.setNavigationItemSelectedListener(this)
        getNavigationView()?.setCheckedItem(getNavigationItemId())

        title = getString(R.string.activity_kotlin_and_react)

        var transaction = supportFragmentManager?.beginTransaction()
        transaction?.add(R.id.fragment_container, KotlinToReactFragment())?.commit()

    }

    /*override fun onPause() {
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
    }*/

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else if (supportFragmentManager?.backStackEntryCount ?: 0 > 0) {
            supportFragmentManager?.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val itemSelected = super.onNavigationItemSelected(item)
        unCheckAllMenuItems(getNavigationView()?.menu)
        return itemSelected
    }

    override fun getDrawerLayout(): DrawerLayout? = drawer_layout

    override fun getNavigationView(): NavigationView? = nav_view

    override fun getNavigationItemId(): Int = R.id.nav_kotlin_and_react

    fun createRNFragment(): Fragment? {
        val fragment = Fragment()

        /*mReactRootView = ReactRootView(this)
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(application)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(MainReactPackage())
                .addPackage(NavigationExternalPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build()
        // The string here (e.g. "MyReactNativeApp") has to match
        // the string in AppRegistry.registerComponent() in index.js
        mReactRootView!!.startReactApplication(mReactInstanceManager, "nwrn", null)

        mReactRootView!!.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        react_container.addView(mReactRootView)*/

        return fragment
    }
}