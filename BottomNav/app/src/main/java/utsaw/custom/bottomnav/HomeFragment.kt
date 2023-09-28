import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import utsaw.custom.bottomnav.ImageSliderAdapter
import utsaw.custom.bottomnav.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager = view.findViewById(R.id.view_pager)
        val indicatorContainer = view.findViewById<LinearLayout>(R.id.indicatorContainer)

        val images = listOf(R.drawable.offer, R.drawable.offer, R.drawable.offer)
        val adapter = ImageSliderAdapter(images)
        viewPager.adapter = adapter

        for (i in images.indices) {
            val indicatorView = LayoutInflater.from(context)
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

        return view
    }
}
