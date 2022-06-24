package com.example.labonabrewery.ui.beers

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import com.example.labonabrewery.R
import com.example.labonabrewery.databinding.FragmentBeersBinding


class BeersFragment : Fragment() {

    private var _binding: FragmentBeersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var imageIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBeersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val variable bind with widgets
        val beerTitle: TextView = binding.beerTitle
        val beerDescription: TextView = binding.beerDescription
        val buttonNext: Button = binding.buttonNext
        val buttonPrevious: Button = binding.buttonPrevious
        val viewFlipper: ViewFlipper = binding.viewFlipper

        buttonNext.text = ">>"
        buttonPrevious.text = "<<"

        //function to set beer values ( title, description, font color, background color )
        fun setBeer(
            beerName: String,
            textColor: Int,
            beerMoreInfo: String,
            beerDescriptionColor: Int,
            backgroundColor: String
        ) {
            beerTitle.text = beerName
            beerTitle.setTextColor(textColor)
            beerDescription.text = beerMoreInfo
            beerDescription.setTextColor(beerDescriptionColor)
            view?.setBackgroundColor(Color.parseColor(backgroundColor))

        }

        //function to get Beer values
        fun getBeer() {
            if (imageIndex == 0) {
                setBeer(
                    requireContext().getString(R.string.porterTitle),
                    Color.WHITE,
                    requireContext().getString(R.string.porterDescription),
                    Color.WHITE,
                    requireContext().getString(0+R.color.porterBackground)
                )
            } else if (imageIndex == 1) {
                setBeer(
                    requireContext().getString(R.string.apaTitle),
                    Color.BLACK,
                    requireContext().getString(R.string.apaDescription),
                    Color.BLACK,
                    requireContext().getString(0+R.color.apaBackground)
                )
            } else if (imageIndex == 2) {
                setBeer(
                    requireContext().getString(R.string.ipaTitle),
                    Color.BLACK,
                    requireContext().getString(R.string.ipaDescription),
                    Color.BLACK,
                    requireContext().getString(0+R.color.ipaBackground)
                )
            } else {
                setBeer(
                    requireContext().getString(R.string.blondeTitle),
                    Color.BLACK,
                    requireContext().getString(R.string.blondeDescription),
                    Color.BLACK,
                    requireContext().getString(0+R.color.blondeBackground)
                )
            }
        }


        //get first BEER
        getBeer()

        //next beer button
        buttonNext.setOnClickListener {
            if (imageIndex >= 3) { //when showing last beer, set value to start again
                imageIndex = 0
            } else {
                imageIndex++
            }
            getBeer()
            viewFlipper.setInAnimation(activity, R.anim.next_in)
            viewFlipper.setOutAnimation(activity, R.anim.next_out)
            viewFlipper.showNext()
        }

        //previous beer button
        buttonPrevious.setOnClickListener {
            if (imageIndex <= 0) {
                imageIndex = 3
            } else {
                imageIndex--
            }
            getBeer()
            viewFlipper.setInAnimation(activity, R.anim.prev_in)
            viewFlipper.setOutAnimation(activity, R.anim.prev_out)
            viewFlipper.showPrevious()
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

