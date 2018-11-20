package com.sf.nwrn.Activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.sf.nwrn.Fragments.KotlinFirstFragment
import com.sf.nwrn.R
import kotlinx.android.synthetic.main.activity_kotlin.*
import kotlinx.android.synthetic.main.app_bar_kotlin.*

class KotlinActivity : BaseActivity() {

    var actionBarDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        setSupportActionBar(toolbar)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, getDrawerLayout(), toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        actionBarDrawerToggle?.let {
            drawer_layout.addDrawerListener(it)
            it.syncState()

            it.setToolbarNavigationClickListener {
                onBackPressed()
            }
        }

        getNavigationView()?.setNavigationItemSelectedListener(this)
        getNavigationView()?.setCheckedItem(getNavigationItemId())

        title = getString(R.string.activity_kotlin)

        var transaction = supportFragmentManager?.beginTransaction()
        transaction?.add(R.id.fragment_container, KotlinFirstFragment())?.commit()
    }

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

    override fun getNavigationItemId(): Int = R.id.nav_kotlin
}
