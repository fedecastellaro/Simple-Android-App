package com.example.parcial1.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.wajahatkarim3.roomexplorer.RoomExplorer


import com.example.parcial1.R
import com.example.parcial1.database.appDatabase
import com.example.parcial1.database.daoUsuarios
import com.example.parcial1.entities.Usuarios
import com.example.parcial1.view.LoginViewModel
import com.google.android.material.snackbar.Snackbar


class Login : Fragment() {
    lateinit var vLogin: View

    private lateinit var viewModel: LoginViewModel
    lateinit var buttonLogin: Button
    lateinit var buttonRegister: TextView
    lateinit var userName: EditText
    lateinit var userPassword: EditText
    lateinit var loginRootLayout: ConstraintLayout


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        vLogin = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)//Aca instancio al viewmodelLOgin

        buttonLogin = vLogin.findViewById(R.id.buttonLogin)
        buttonRegister = vLogin.findViewById(R.id.registerClick)
        userName = vLogin.findViewById(R.id.userName)
        userPassword = vLogin.findViewById(R.id.userPassword)
        loginRootLayout = vLogin.findViewById(R.id.frameLayoutLogin)

        return vLogin
    }

    override fun onStart() {
        super.onStart()

        buttonLogin.setOnClickListener {

            if (userName.text.trim().isNotEmpty() && userPassword.text.trim().isNotEmpty())
            {
                if (viewModel.searchPerson(Usuarios(userName.text.toString(), "",userPassword.text.toString(),0)))
                {
                    val action2 = LoginDirections.actionLoginToMainActivity2()
                    vLogin.findNavController().navigate(action2)
                }
                else
                {
                    Snackbar.make(loginRootLayout, "Usuario no encontrado", Snackbar.LENGTH_SHORT).show()
                }
            }
            else
            {
                if (userName.text.trim().isNotEmpty() && userPassword.text.trim().isEmpty())
                {
                    if (userName.text.toString() == "debug")
                    {
                        val action2 = LoginDirections.actionLoginToDebug()
                        vLogin.findNavController().navigate(action2)
                    }
                }
                if (userName.text.trim().isEmpty()) {
                    Snackbar.make(loginRootLayout, "Campo de Usuario vacio", Snackbar.LENGTH_SHORT).show()
                }
                else if (userPassword.text.trim().isEmpty()) {
                    Snackbar.make(loginRootLayout, "Password vacio", Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        buttonRegister.setOnClickListener {
            val action = LoginDirections.actionLoginToRegister()
            vLogin.findNavController().navigate(action)
        }
    }
}