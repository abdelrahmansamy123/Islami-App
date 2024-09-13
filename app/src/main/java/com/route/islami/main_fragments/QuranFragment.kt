package com.route.islami.main_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.Constants
import com.route.islami.R
import com.route.islami.callbacks.OnSuraClickListener
import com.route.islami.data.model.ArSuras
import com.route.islami.main_fragments.adapter.SurasNameAdapter
import com.route.islami.quran_details.SuraDetailsActivity

class QuranFragment : Fragment() {
    lateinit var quranRecyclerView: RecyclerView
    lateinit var quranAdapter: SurasNameAdapter
    lateinit var switchModeButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView = view.findViewById(R.id.quran_recycler_view)
        switchModeButton = view.findViewById(R.id.switch_mode)


        switchModeLogic()
        quranAdapter = SurasNameAdapter(ArSuras)
        quranRecyclerView.adapter = quranAdapter
        quranRecyclerView.layoutManager = LinearLayoutManager(context)
        quranAdapter.onSuraClickListener = object : OnSuraClickListener {
            override fun onSuraClick(position: Int, suraName: String) {
                val intent1 = Intent(requireActivity(), SuraDetailsActivity::class.java)
                intent1.putExtra(Constants.EXTRA_SURA_POSITION, position)
                intent1.putExtra(Constants.EXTRA_SURA_NAME_KEY, suraName)
                startActivity(intent1)
            }

        }

    }

    fun switchModeLogic() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            switchModeButton.text = "Light"
        } else {
            switchModeButton.text = "Dark"
        }
        switchModeButton.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchModeButton.text = "Dark"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchModeButton.text = "Light"
            }
        }
    }


}