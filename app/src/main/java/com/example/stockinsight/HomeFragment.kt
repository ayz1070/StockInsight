package com.example.stockinsight

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stockinsight.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment

        binding.button.setOnClickListener{
            val intent = Intent(requireContext(),StartActivity::class.java)
            startActivity(intent)
        }
        return binding.root


    }


}