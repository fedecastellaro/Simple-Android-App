package com.example.parcial1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.parcial1.R


class Tab_3(texto:String) : Fragment() {
    lateinit var v : View
    lateinit var textotab3: TextView

    var  id = texto

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tab_3, container, false)
        textotab3 = v.findViewById(R.id.textTab_3)

        return v
    }

    override fun onStart() {
        super.onStart()
        textotab3.setText(id + " a recordar")

        if (id == "1") // -> examenes
        {

        }
        if (id == "2") // -> examenes
        {

        }
        if (id == "3") // -> examenes
        {

        }
        else
        {

        }
    }

}