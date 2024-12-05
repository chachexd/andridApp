package com.example.tablelayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

class ControladorVentanasDeslizantes(supportFragmentManager:FragmentManager):
    FragmentStatePagerAdapter(supportFragmentManager) {
    private val listaFragmentos = ArrayList<Fragment>()
    private val listaTitulosFragmentos =  ArrayList<String>()
    fun addFragment(fragment: Fragment, title:String){
        listaFragmentos.add(fragment)
        listaTitulosFragmentos.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return listaFragmentos[position]
    }

    override fun getCount(): Int {
        return listaFragmentos.size

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listaTitulosFragmentos[position]
    }
}