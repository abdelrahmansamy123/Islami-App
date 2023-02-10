package com.route.islami.main_fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islami.R
import com.route.islami.callbacks.OnSuraClickListener


class SurasNameAdapter(var suras : List<String>, var count : Int = 286) :
    RecyclerView.Adapter<SurasNameAdapter.surasNamesNiewHolder>(){

    var onSuraClickListener : OnSuraClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): surasNamesNiewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.quran_list_item,parent,false)
        return surasNamesNiewHolder(view)
    }

    override fun onBindViewHolder(holder: surasNamesNiewHolder, position: Int) {
        holder.suraName.text = suras.get(position)
        holder.suraContentCount.text = "$count"
        holder.itemView.setOnClickListener {
            onSuraClickListener?.onSuraClick(position,suras.get(position))
        }
    }

    override fun getItemCount(): Int {
        return suras.size
    }
    class surasNamesNiewHolder (val itemView : View ) : ViewHolder(itemView){

        var suraName : TextView
        var suraContentCount : TextView

        init {
            suraName = itemView.findViewById(R.id.suras_name)
            suraContentCount = itemView.findViewById(R.id.suras_content_count)
        }
    }




}