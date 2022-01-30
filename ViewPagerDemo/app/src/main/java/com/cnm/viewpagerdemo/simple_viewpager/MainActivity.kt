package com.cnm.viewpagerdemo.simple_viewpager

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.cnm.viewpagerdemo.R
import com.cnm.viewpagerdemo.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {
    private lateinit var bi: ActivityMainBinding
    private lateinit var vm: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProvider(this)[MyViewModel::class.java]
        bi.lifecycleOwner = this
        bi.vm = vm
        initfun()

    }

    private fun initfun() {
        val adapter = createAFragmentAdapter()
        bi.pager.adapter = adapter
    }

    fun createAFragmentAdapter() = ViewPagerFragmentAdapter(this, vm.NUM_PAGES)
    override fun onBackPressed() {
        if (bi.pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            bi.pager.currentItem = bi.pager.currentItem - 1
        }
    }
}


