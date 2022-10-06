package com.example.practice.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practice.R
import com.example.practice.entities.Item
import com.google.android.material.bottomnavigation.BottomNavigationView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pagina2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pagina2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var vista2 : View
    lateinit var textoUsuarioRecibido : TextView
    lateinit var itemsRecycler : RecyclerView
    var items : MutableList<Item> = ArrayList<Item>()
    lateinit var bottomBar: BottomNavigationView
    lateinit var imageView : ImageView

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

        vista2 = inflater.inflate(R.layout.fragment_pagina2, container, false)

        textoUsuarioRecibido = vista2.findViewById(R.id.textoUsuarioRecibido)

        itemsRecycler = vista2.findViewById(R.id.items_recycler)

        bottomBar = requireActivity().findViewById<BottomNavigationView>(com.example.practice.R.id.bottom_bar)

        bottomBar.visibility = View.VISIBLE

        imageView = vista2.findViewById(R.id.imageView)

        return vista2
    }

    override fun onStart() {
        super.onStart()
        textoUsuarioRecibido.text = "Hola, " +  Pagina2Args.fromBundle(requireArguments()).userName

        items.add(Item("Iphone", "$100", "test1"))
        items.add(Item("Remera", "$200", "test2"))

        itemsRecycler.setHasFixedSize(true)
        itemsRecycler.layoutManager = LinearLayoutManager(context)
        //itemsRecycler.adapter =

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Pagina2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pagina2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}