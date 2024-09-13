package com.route.islami.quran_details

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.Constants
import com.route.islami.R
import com.route.islami.quran_details.adapter.SuraContentAdapter

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var suraContentRecyclerView: RecyclerView
    lateinit var adapter: SuraContentAdapter
    lateinit var suraNameTextView: TextView
    lateinit var backIcon: ImageView
    var suraPosition: Int? = null
    var suraName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suraContentRecyclerView = findViewById(R.id.sura_content_recycler_view)
        adapter = SuraContentAdapter(null)
        suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME_KEY)
        suraPosition = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)
        suraContentRecyclerView.adapter = adapter
        readFileText()
        suraNameTextView = findViewById(R.id.suras_name)
        backIcon = findViewById(R.id.back_icon)
        suraNameTextView.text = suraName
        backIcon.setOnClickListener {
            finish()
        }
    }

    fun readFileText() {
        val fileName = "${suraPosition?.plus(1)}.txt"
        val fileContent: String = assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
        val suraContent = fileContent.split('\n')
        adapter.updateData(suraContent)
    }
}
