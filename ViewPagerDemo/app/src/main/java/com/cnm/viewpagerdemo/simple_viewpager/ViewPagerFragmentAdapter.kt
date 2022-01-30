package com.cnm.viewpagerdemo.simple_viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cnm.viewpagerdemo.*
import com.cnm.viewpagerdemo.vp_tablayout.Interactors
import com.cnm.viewpagerdemo.vp_tablayout.TabLayoutVPActivity

class ViewPagerFragmentAdapter(val activity: FragmentActivity, val totalPages: Int) :
    FragmentStateAdapter(activity) {
    override fun getItemCount() = totalPages

    override fun createFragment(position: Int): Fragment {
        log(m = "$position")
        return when (position) {
            1 -> {
                F1Fragment()
            }
            2 -> {
                F2Fragment()
            }
            3 -> {
                F3Fragment()
            }
            4 -> {
                F4Fragment()
            }
            5 -> {
                F5Fragment()
            }
            else -> {
                F3Fragment()
            }
        }

    }
}