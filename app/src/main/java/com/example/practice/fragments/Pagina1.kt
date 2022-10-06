package com.example.practice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.practice.R
import com.google.android.material.bottomnavigation.BottomNavigationView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pagina1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pagina1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
     lateinit var vista : View
     lateinit var botonContinuar : Button
     lateinit var textoUsuario : EditText
     lateinit var bottomBar: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(com.example.practice.R.layout.fragment_pagina1, container, false)

        botonContinuar = vista.findViewById(com.example.practice.R.id.buttonContinue)

        textoUsuario = vista.findViewById(com.example.practice.R.id.nombreUsuario)

        bottomBar = requireActivity().findViewById<BottomNavigationView>(com.example.practice.R.id.bottom_bar)

        bottomBar.visibility = View.GONE

        return vista
    }

    override fun onStart() {
        super.onStart()

        botonContinuar.setOnClickListener{
            var mensaje = textoUsuario.text.toString()

            val action = Pagina1Directions.actionPagina1ToPagina2(mensaje)

            vista.findNavController().navigate(action)

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Pagina1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pagina1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}