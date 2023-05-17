package com.example.projectutsdefrymaulana.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectutsdefrymaulana.DetailMovieActivity
import com.example.projectutsdefrymaulana.Movie
import com.example.projectutsdefrymaulana.MovieAdapter
import com.example.projectutsdefrymaulana.R

class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList : ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
//        adapter = MovieAdapter(movieArrayList)
        recyclerView.adapter = context?.let {
            MovieAdapter(it, movieArrayList){
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.galaxya13,
            R.drawable.ip14,
            R.drawable.ipad9,
            R.drawable.oppoa77,
            R.drawable.pocom4pro,
            R.drawable.realmec55,
            R.drawable.redminote12,
            R.drawable.s23,
            R.drawable.xr,
            R.drawable.zflip,

            )

        title = arrayOf(
            "SAMSUNG GALAXY A13",
            "IPHONE 14 PRO MAX",
            "IPAD GEN 9TH",
            "OPPO A77S",
            "POCO M4 PRO",
            "REALME C55",
            "REDMI NOTE 12",
            "SAMSUNG S23 ULTRA",
            "IPHONE XR",
            "SAMSUNG Z FLIP 4",


            )

        descriptions = arrayOf(
            "Rp.4.400.000",
            "Rp.14.500.000",
            "Rp.6.000.000",
            "Rp.3.400.000",
            "Rp.5.500.000",
            "Rp.5.000.000",
            "Rp.5.400.000",
            "Rp.10.000.000",
            "Rp.3.700.000",
            "Rp.13.000.000",


            )

        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }

    }

}