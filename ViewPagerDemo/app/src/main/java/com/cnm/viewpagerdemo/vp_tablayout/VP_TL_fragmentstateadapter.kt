package com.cnm.viewpagerdemo.vp_tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cnm.viewpagerdemo.*

class VP_TL_fragmentstateadapter(val totalPages: Int, fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount() = totalPages


    override fun createFragment(position: Int): Fragment {
        log(m = "$position")
        return when (position) {
            0 -> {
                F5Fragment()
            }
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
            else -> {
                F3Fragment()
            }
        }
    }
}