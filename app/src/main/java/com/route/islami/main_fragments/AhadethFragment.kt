package com.route.islami.main_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.Hadeth
import com.route.islami.R

class AhadethFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()

    }

    val allAhadeth = mutableListOf<Hadeth>()
    fun readHadethFile() {
        val fileContent = activity?.assets?.open("ahadeth.txt")?.bufferedReader().use {
            it?.readText()
        }
        if (fileContent == null) return;
        val ahadethContents = fileContent.trim().split("#")
        ahadethContents.forEach { singleHadethContent ->
            // val indexOfFirstLine = singleHadethContent.indexOf('\n')
            // val title = singleHadethContent.substring(0,indexOfFirstLine)
            val title = singleHadethContent.trim().substringBefore('\n')
            val content = singleHadethContent.trim().substringAfter('\n')
            val hadeth = Hadeth(title, content)
            allAhadeth.add(hadeth)

        }
    }

}