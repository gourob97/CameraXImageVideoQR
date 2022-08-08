package com.example.cameraximagevideoqr.image_video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cameraximagevideoqr.R
import com.example.cameraximagevideoqr.databinding.FragmentSelectionBinding

class SelectionFragment : Fragment() {

    private var _binding : FragmentSelectionBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectionBinding.inflate(inflater, container, false)

        binding.imageVideo.setOnClickListener{
            findNavController().navigate(R.id.action_selectionFragment_to_imageVideoFragment)
        }


        binding.qr.setOnClickListener{
            findNavController().navigate(R.id.action_selectionFragment_to_QRFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}