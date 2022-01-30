package com.cnm.viewpagerdemo.vp_tablayout

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.cnm.viewpagerdemo.R
import com.cnm.viewpagerdemo.databinding.ActivityTabLayoutVpactivityBinding
import com.cnm.viewpagerdemo.simple_viewpager.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutVPActivity : AppCompatActivity() {
    private lateinit var bi: ActivityTabLayoutVpactivityBinding
    private lateinit var vm: TabVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_tab_layout_vpactivity)
        bi.lifecycleOwner = this
        vm = ViewModelProvider(this).get(TabVM::class.java)
        initfun()
    }

    private fun initfun() {
        initViewPager()
        initTabs()
        attachViewPagerWithTabLayout()
    }


    // region view pager implementaton
    private fun initViewPager() {
        var adapter = VP_TL_fragmentstateadapter(5, supportFragmentManager, lifecycle)
        bi.pager.adapter = adapter
    }
    //endregion

    //region tab implementation
    private fun initTabs() {
        bi.tabLayout.tabMode = TabLayout.MODE_AUTO
        bi.tabLayout.textAlignment = TabLayout.TEXT_ALIGNMENT_CENTER
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            bi.tabLayout.setTabTextColors(getColor(R.color.black), getColor(R.color.teal_200))
//        }
    }

    //endregion

    // region attach viewpager with tabLayout
    private fun attachViewPagerWithTabLayout() {
        TabLayoutMediator(bi.tabLayout, bi.pager) { tab, position ->
            tab.text = " $position "
        }.attach()
    }

//endregion
}

