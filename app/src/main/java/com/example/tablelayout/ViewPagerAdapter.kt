package com.example.tablelayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList: ArrayList<Fragment> = ArrayList()
    private val fragmentTitleList: ArrayList<String> = ArrayList()

    init {
        // Añadir fragmentos y títulos
        fragmentList.add(ContactosFragment())  // Fragment para la primera pestaña
        fragmentTitleList.add("Home")

        fragmentList.add(CorreosFragment())  // Fragment para la segunda pestaña
        fragmentTitleList.add("Settings")
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }
}
