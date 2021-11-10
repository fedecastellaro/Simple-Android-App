package com.example.parcial1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.parcial1.R
import com.example.parcial1.database.appDatabase
import com.example.parcial1.database.daoUsuarios
import com.example.parcial1.entities.Usuarios
import com.example.parcial1.view.LoginViewModel
import com.google.android.material.snackbar.Snackbar


class Register : Fragment() {

    lateinit var vRegister      : View
    lateinit var RegisterButton : Button
    lateinit var newUser        : EditText
    lateinit var newUserMail    : EditText
    lateinit var newUserPass    : EditText
    lateinit var registerRootLayout: ConstraintLayout
    private lateinit var viewModel: LoginViewModel

    private var  i : Int = 1


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        vRegister = inflater.inflate(R.layout.fragment_register, container, false)

        RegisterButton = vRegister.findViewById(R.id.RegisterButton)
        newUser = vRegister.findViewById(R.id.newUser)
        newUserMail = vRegister.findViewById(R.id.newUserMail)
        newUserPass = vRegister.findViewById(R.id.newUserPass)
        registerRootLayout = vRegister.findViewById((R.id.frameLayout2))
        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)//Aca instancio al viewmodelLOgin


        return vRegister
    }

    override fun onStart() {
        super.onStart()

            RegisterButton.setOnClickListener {
                if (newUser.text.trim().isNotEmpty() && newUserPass.text.trim().isNotEmpty())
                {
                    val user = Usuarios(newUser.text.toString(), newUserMail.text.toString(), newUserPass.text.toString(), viewModel.i++)
                    viewModel.insertPersonInfo(user)

                    Snackbar.make(registerRootLayout, "Usuario registrado con exito!", Snackbar.LENGTH_SHORT).show()

                }

            }


    }
}


