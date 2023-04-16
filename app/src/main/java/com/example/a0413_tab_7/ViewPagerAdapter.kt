package com.example.a0413_tab_7

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragment : FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> WeatherFragment()
            2 -> ClosetFragment()
            else -> CommunityFragment()
        }
    }
}