package com.example.mobileapps1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewPagerAdapter(private val context: Context) : PagerAdapter(){

    private lateinit var viewPager : ViewPager

    //Array to show posters
    private var images = mutableListOf<Int>(R.drawable.air,
        R.drawable.dung_dragons,R.drawable.renfield,
        R.drawable.john_wick)

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    //Attach pics from array
    override fun instantiateItem(container: ViewGroup, position: Int) : Any {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.cust_movie, container, false)

        val imageView : ImageView = view.findViewById(R.id.customImg)
        imageView.setImageResource(images[position])

        viewPager = container as ViewPager
        viewPager.addView(view, 0)

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
       viewPager = container as ViewPager

        val view : View = `object` as View

        viewPager.removeView(view)
    }

}