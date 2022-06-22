package com.example.labonabrewery.ui.contact

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.labonabrewery.databinding.FragmentContactBinding


class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val addressTitle: TextView = binding.addressTitle
        val addressValue: TextView = binding.addressValue
        val contactNumberTitle: TextView = binding.numberTitle
        val contactNumberValue: TextView = binding.numberValue
        val emailTitle: TextView = binding.emailTitle
        val emailValue: TextView = binding.emailValue
        val facebook: ImageView = binding.facebook
        val instagram: ImageView = binding.instagram

        addressTitle.text = "ADRESA"
        addressValue.text = "Štrmac 1, 52220 Labin - HR"
        contactNumberTitle.text = "TELEFON"
        contactNumberValue.text = "+385 99 4965 785"
        emailTitle.text = "EMAIL"
        emailValue.text = "info@labona.hr"

        addressValue.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG)
        contactNumberValue.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG)
        emailValue.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG)

        val address = "Labona craft brewery Labin"
        val mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address))
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        addressValue.setOnClickListener {
            startActivity(mapIntent)
        }


        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+385994965785")

        contactNumberValue.setOnClickListener {
            startActivity(intent)
        }

        val intentEmail = Intent(Intent.ACTION_MAIN)
        intentEmail.addCategory(Intent.CATEGORY_APP_EMAIL)

        emailValue.setOnClickListener {
            startActivity(intentEmail)
        }

        facebook.setOnClickListener {
            var uri = Uri.parse("fb://page/107622175137886")
            val face = Intent(Intent.ACTION_VIEW, uri)
            face.setPackage("com.facebook.katana")
            try {
                    startActivity(face)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://facebook.com/labonacraftbrewery")
                    )
                )
            }

        }



        instagram.setOnClickListener {
            val uri = Uri.parse("http://instagram.com/_u/labonacraftbrewery")
            val likeIng = Intent(Intent.ACTION_VIEW, uri)
            likeIng.setPackage("com.instagram.android")

            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/labonacraftbrewery")
                    )
                )
            }
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}