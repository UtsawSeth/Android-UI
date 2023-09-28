package utsaw.custom.bottomnav

import HomeFragment
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

     private lateinit var fragmentManager: FragmentManager
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        //bottomNavigation.setOnNavigationItemSelectedListener(this)

        fragmentManager = supportFragmentManager


       /* val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val indicatorContainer = findViewById<LinearLayout>(R.id.indicatorContainer)

        val images = listOf(R.drawable.offer, R.drawable.offer, R.drawable.offer)

        val adapter = ImageSliderAdapter(images)
        viewPager.adapter = adapter*/


        // Initial fragment (HomeFragment)
        loadFragment(HomeFragment())

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_Home -> loadFragment(HomeFragment())
                R.id.scanQR -> loadFragment(NotificationFragment())
                R.id.myProfile -> loadFragment(DashboardFragment())
            }
            true
        }

        /*bottomNavigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.scanQR -> {
                    // Handle item 1 click
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.myQR -> {
                    // Handle item 2 click
                    return@setOnNavigationItemSelectedListener true
                }
                // Add more cases for other items as needed
                else -> false
            }
        }*/

       /* for (i in images.indices) {
            val indicatorView = LayoutInflater.from(this)
                .inflate(R.layout.indicator_layout, indicatorContainer, false)
            indicatorContainer.addView(indicatorView)

            indicatorView.setOnClickListener {
                viewPager.setCurrentItem(i, true)
            }

            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    // Not used in this example
                }

                override fun onPageSelected(position: Int) {
                    for (index in 0 until indicatorContainer.childCount) {
                        val indicator = indicatorContainer.getChildAt(index) as ImageView
                        indicator.setImageResource(if (index == position) R.drawable.selected else R.drawable.unselected)
                    }
                }

                override fun onPageScrollStateChanged(state: Int) {
                    // Not used in this example
                }
            })

        }
*/

    }
    /*override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fragment: Fragment = when (item.itemId) {

            R.id.bottom_Home -> {
                // Replace with the fragment you want to show when the dashboard icon is clicked
                HomeFragment()
            }
            R.id.scanQR -> {
                // Replace with the fragment you want to show when the dashboard icon is clicked
                NotificationFragment()
            }
            R.id.myProfile -> {
                // Replace with the fragment you want to show when the dashboard icon is clicked
                DashboardFragment()
            }

            else -> HomeFragment() // Default to blank fragment
        }

        return loadFragment(fragment)
    }*/

    /*private fun loadFragment(fragment: Fragment): Boolean {
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.commit()
        return true
    }*/

    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null) // Optional: Add to back stack for fragment navigation
        transaction.commit()
    }
}