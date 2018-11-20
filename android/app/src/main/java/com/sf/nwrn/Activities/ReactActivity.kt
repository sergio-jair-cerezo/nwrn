package com.sf.nwrn.Activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import com.sf.nwrn.R
import kotlinx.android.synthetic.main.activity_react.*
import kotlinx.android.synthetic.main.app_bar_react.*
import com.sf.nwrn.Bridging.ReactEmbededHelper

class ReactActivity : ReactBaseActivity(), DefaultHardwareBackBtnHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_react)
        setSupportActionBar(toolbar)
        toolbar.visibility = View.GONE

        val actionBarDrawerToggle = ActionBarDrawerToggle(this, getDrawerLayout(), toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()

        getNavigationView()?.setNavigationItemSelectedListener(this)
        getNavigationView()?.setCheckedItem(getNavigationItemId())

        mReactInstanceManager = ReactEmbededHelper.getReactInstanceManager(application)
        mReactInstanceManager?.let {
            mReactRootView = ReactEmbededHelper.getReactRootView(this, it, null)
            react_container.addView(mReactRootView)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val itemSelected = super.onNavigationItemSelected(item)
        unCheckAllMenuItems(getNavigationView()?.menu)
        return itemSelected
    }

    override fun getDrawerLayout(): DrawerLayout? = drawer_layout

    override fun getNavigationView(): NavigationView? = nav_view

    override fun getNavigationItemId(): Int = R.id.nav_react
}