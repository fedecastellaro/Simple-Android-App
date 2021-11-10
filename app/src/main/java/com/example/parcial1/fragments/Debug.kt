package com.example.parcial1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.parcial1.R
import com.example.parcial1.database.appDatabase
import com.example.parcial1.entities.Usuarios
import com.example.parcial1.view.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import com.wajahatkarim3.roomexplorer.RoomExplorer

class Debug : Fragment() {

    private lateinit var viewModel: LoginViewModel
    lateinit var debugButton: Button
    lateinit var eliminarButton: Button
    lateinit var UsuarioSelector: EditText

    lateinit var vDebug : View
    lateinit var debugRootLayout: ConstraintLayout


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        vDebug = inflater.inflate(R.layout.fragment_debug, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)//Aca instancio al viewmodelLOgin

        debugButton = vDebug.findViewById(R.id.DebugButton)
        eliminarButton = vDebug.findViewById(R.id.eliminarbutton)
        UsuarioSelector = vDebug.findViewById(R.id.UsuarioSelector)
        debugRootLayout = vDebug.findViewById(R.id.frameLayout4)

        return vDebug
    }

    override fun onStart() {
        super.onStart()

        debugButton.setOnClickListener {
            RoomExplorer.show(context, appDatabase::class.java, "myDB")

        }

        eliminarButton.setOnClickListener {

            if (UsuarioSelector.text.trim().isNotEmpty())
            {
                if(viewModel.deleteUserInfo(Usuarios(UsuarioSelector.text.toString(),"","",0)))
                {
                    Snackbar.make(debugRootLayout, "Usuario Eliminado", Snackbar.LENGTH_SHORT).show()
                }
            }
            else
            {
                Snackbar.make(debugRootLayout, "Usuario No Encontrado", Snackbar.LENGTH_SHORT).show()
            }
        }

    }

    }