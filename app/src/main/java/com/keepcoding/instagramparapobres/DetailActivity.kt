package com.keepcoding.instagramparapobres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keepcoding.instagramparapobres.gallery.Image

class DetailActivity : AppCompatActivity() {

    lateinit var image: Image
    lateinit var imagesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        image = intent.getParcelableExtra<Image>(MainActivity.INTENT_LIST_KEY) as Image
        title = image.title

        imagesRecyclerView = findViewById(R.id.detail_recycler_view)
        imagesRecyclerView.layoutManager = LinearLayoutManager(this)
        imagesRecyclerView.adapter = ImagesRecyclerAdapter(image)
    }
}