package com.example.cameraximagevideoqr.QR

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import me.dm7.barcodescanner.zxing.ZXingScannerView
import com.google.zxing.Result


class QRFragment : Fragment(),  ZXingScannerView.ResultHandler{

//    private var _binding : FragmentQRBinding? = null
//    private val binding
//        get() = _binding!!

    var scannerView : ZXingScannerView? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        scannerView = ZXingScannerView(requireActivity())

        setPermission()

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_q_r, container, false)
        return scannerView
    }

    private fun setPermission() {
        val permission = ContextCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.CAMERA)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            requireActivity(), arrayOf(android.Manifest.permission.CAMERA),
            1
        )
    }

    override fun handleResult(p0: Result?) {
       // Toast.makeText(requireContext(), "${p0!!.text}", Toast.LENGTH_SHORT).show()
        findNavController().navigate(QRFragmentDirections.actionQRFragmentToScanResultFragment(p0!!.text))
    }

    override fun onResume() {
        super.onResume()
        scannerView?.setResultHandler(this)
        scannerView?.startCamera()
    }

    override fun onStop() {
        super.onStop()
        scannerView?.stopCamera()
//        onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1 -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(
                        requireContext(),
                        "You need camera permission",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


}