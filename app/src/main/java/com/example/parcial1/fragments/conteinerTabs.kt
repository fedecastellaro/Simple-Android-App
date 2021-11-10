package com.example.parcial1.fragments

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.Person.fromBundle
import androidx.fragment.app.FragmentActivity
import androidx.media.AudioAttributesCompat.fromBundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.parcial1.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class conteinerTabs : Fragment() {
    lateinit var v: View
    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_conteiner_tabs, container, false)

        tabLayout = v.findViewById(R.id.tab_layout)
        viewPager = v.findViewById(R.id.view_pager)

        return v
    }

    override fun onStart() {
        super.onStart()

        var textoTab = conteinerTabsArgs.fromBundle(requireArguments()).textoTab

        viewPager.setAdapter(ViewPagerAdapter(requireActivity(),textoTab))

        TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
             when (position) {
                0 -> {
                    tab.text = "Urgente!"
                    tab.setIcon(R.drawable.ic_baseline_priority_high_24)
                }
                1 -> {
                    tab.text = "To DO"
                    tab.setIcon(R.drawable.ic_baseline_assignment_late_24)
                }
                2 -> {
                    tab.text = "Eventual"
                    tab.setIcon(R.drawable.ic_baseline_architecture_24)
                }
                else -> tab.text = "Eventual"
            }
        }).attach()
    }


    class ViewPagerAdapter(fragmentActivity: FragmentActivity, texto: String) : FragmentStateAdapter(fragmentActivity) {

        var nombre = texto

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> Tab_1(nombre)
                1 -> Tab_2(nombre)
                2 -> Tab_3(nombre)

                else -> Tab_1(nombre)
            }
        }

        override fun getItemCount(): Int {
            return TAB_COUNT
        }

        companion object {
            private const val TAB_COUNT = 3
        }
    }

}