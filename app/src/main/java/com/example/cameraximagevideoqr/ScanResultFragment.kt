package com.example.cameraximagevideoqr

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.navigation.fragment.navArgs
import com.example.cameraximagevideoqr.databinding.FragmentScanResultBinding


class ScanResultFragment : Fragment() {

    val args : ScanResultFragmentArgs by navArgs()
    private var _binding: FragmentScanResultBinding? = null
    private val binding
        get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val output = args.output
        _binding = FragmentScanResultBinding.inflate(inflater, container,false)

        binding.result.text = output.toString()


        binding.copyButton.setOnClickListener{
            val clipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", args.output)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(requireContext(), "Result copied", Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }


}