package com.route.islami.main_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islami.Constants
import com.route.islami.R

class TasbeehFragment : Fragment() {

    lateinit var image: ImageView
    lateinit var phase: TextView
    lateinit var counterTv: TextView
    var counter: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeeh,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.img_sebha)
        counterTv =view.findViewById(R.id.counter_tv)

        counterTv.text = "$counter"
        phase =view.findViewById(R.id.phase)
        image.setOnClickListener {
            onSebhaClick()
        }

    }

    private fun onSebhaClick(){
        image.rotation = image.rotation +5
        counter++
        counterTv.text ="$counter"
        if (phase.text == Constants.KHATEMA){
            phase.text = Constants.SUBHAN_ALLAH
            counter = 0
            counterTv.text = "$counter"
        }

        if (counter == 33)
            if (phase.text == Constants.SUBHAN_ALLAH){
                phase.text = Constants.ALHAMDUILLAH
                counter = 0

            }
        else if (phase.text == Constants.ALHAMDUILLAH){
                counter = 0
                phase.text = Constants.ALLAH_AKBAR

            }
            else if (phase.text == Constants.ALLAH_AKBAR) {
                phase.text = Constants.KHATEMA
                counter = 0
                counterTv.text = "$counter"
            }
    }



}