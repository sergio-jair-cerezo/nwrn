package com.sf.nwrn.Activities

import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

abstract class BaseActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    abstract fun getDrawerLayout(): DrawerLayout?
    abstract fun getNavigationView(): NavigationView?
    abstract fun getNavigationItemId(): Int

    override fun onBackPressed() {
        getDrawerLayout().also { drawerLayout ->
            if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        } ?: run {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId != getNavigationItemId()) {
            when (item.itemId) {
                /*R.id.nav_analysis_results -> {
                    val intent = Intent(this, AnalysisResultsActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_complaints -> {

                }
                R.id.nav_branches -> {
                    val intent = Intent(this, BranchesActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_company -> {

                }
                R.id.nav_contact_us -> {

                }
                R.id.nav_season_promotion -> {
                    val intent = Intent(this, SeasonPromotionActivity::class.java)
                    startActivity(intent)
                }*/
            }
        }

        getDrawerLayout()?.closeDrawer(GravityCompat.START)
        return true
    }

    protected fun unCheckAllMenuItems(menu: Menu?) {
        val size = menu?.size() ?: 0
        for (i in 0 until size) {
            val item = menu!!.getItem(i)
            if (item!!.hasSubMenu()) {
                unCheckAllMenuItems(item.subMenu)
            } else {
                item.isChecked = false
            }
        }
    }

    protected fun getMenuItemWith(itemId: Int): MenuItem? {
        val size = getNavigationView()?.menu?.size() ?: 0
        for (i in 0 until size) {
            val item = getNavigationView()!!.menu!!.getItem(i)
            if (item!!.itemId == itemId) {
                return item
            }
        }
        return null
    }
}
