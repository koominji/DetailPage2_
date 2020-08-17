package com.kmj.detailpage2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_page2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        back_button2.setOnClickListener {
//
//        }


        tab_layout.addTab(tab_layout.newTab().setText("팬도로시"))
        tab_layout.addTab(tab_layout.newTab().setText("comment"))

        tab_layout.getTabAt(0)?.setIcon(R.drawable.foodicon1)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.comment)

        val pagerAdapter = PagerAdapter(supportFragmentManager, 2)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))


    }
}

class PagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Detail_Page2()
            }
            1 -> {
                return Temp()
            }

            else -> return Detail_Page2()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}
