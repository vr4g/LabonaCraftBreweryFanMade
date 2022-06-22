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


//const values for description text for given beer
    const val porter = "Tamno kestenjaste boje sa primamljivom smeđom pjenom. Prevladavaju note tamne karamele, likoricije i dozrelih crvenih jabuka. Srednjeg tijela i srednje jake gorčine u ovom pivu do izražaja dolaze specijalni prženi tipovi slada koji se koriste u proizvodnji ovog piva. Kao takvo izvrsno paše uz goveđa ili variva sa divljači, meke i sireve sa plemenitom plijesni, te čokoladne deserte i sladoled"

    const val apa = "Jako pivo, zlatno jantarne boje i bijele postojane pjene. Punog tijela i smjele gorčine ovo je pivo prava eksplozija okusa. Note tropskog voća, kojim dominira grapefruit, borovina, muškatni orašćić i cvjetne arome savršeno će upotpuniti vrlo pikantna jela, prženu hranu, ribu, burgere i razne čokoladne slastice."

    const val ipa = "Pivo skladnog tijela i ugodne gorčine, slamnato žute boje. Krasi ga čvrsta bijela pjena koja traje. Glavni aduti ovog piva su aroma cvjetnog meda uz lagane note ananasa i tropskog voća koje osvježavaju. Savršeno odgovara uz burgere, steakove, začinjene salate, polutvrde sireve i voćne deserte."

    const val blonde = "Srednjeg tijela i lagane gorčine dobar je balans između sladnosti i gorčine. Zlatno je žute boje sa tankom bijelom pjenom koja traje. Krušne note sa aromama bagremovog meda i marcipana dodatno će začiniti laganija jela kao što su razne tjestenine, lagane salate, jela od piletine i svježi sir."

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
        val beerTitle : TextView = binding.beerTitle
        val beerDescription : TextView = binding.beerDescription
        val buttonNext : Button = binding.buttonNext
        val buttonPrevious : Button = binding.buttonPrevious
        val viewFlipper : ViewFlipper = binding.viewFlipper


        buttonNext.text = ">"
        buttonPrevious.text = "<"

        //first beer set
        beerTitle.text = "PORTER"
        beerTitle.setTextColor(Color.WHITE)
        beerDescription.setTextColor(Color.WHITE)
        beerDescription.text = porter


        //function to get Beer values
        fun getBeer() {
        if(imageIndex == 0){
            beerTitle.text = "PORTER"
            beerTitle.setTextColor(Color.WHITE)
            beerDescription.text = porter
            beerDescription.setTextColor(Color.WHITE)
            view?.setBackgroundColor(
                Color.rgb(88,40,41)
            )
        }else if(imageIndex == 1){
            beerTitle.text = "AMERICAN PALE ALE"
            beerTitle.setTextColor(Color.BLACK)
            beerDescription.text = apa
            beerDescription.setTextColor(Color.BLACK)
            view?.setBackgroundColor(
                Color.rgb(204,183,55)
            )
        }else if(imageIndex == 2){
            beerTitle.text = "INDIA PALE ALE"
            beerTitle.setTextColor(Color.BLACK)
            beerDescription.text = ipa
            beerDescription.setTextColor(Color.BLACK)
            view?.setBackgroundColor(
                Color.rgb(236,184,47)
            )
        }else{
            beerTitle.text = "BLONDE ALE"
            beerTitle.setTextColor(Color.BLACK)
            beerDescription.text = blonde
            beerDescription.setTextColor(Color.BLACK)
            view?.setBackgroundColor(
                Color.rgb(236,154,79)
            )
        }
        }

        //next beer button
        buttonNext.setOnClickListener {
            if(imageIndex >= 3){ //when showing last beer, set value to start again
                imageIndex = 0
            }else{
                imageIndex++
            }
            getBeer()
            viewFlipper.setInAnimation(activity, R.anim.next_in)
            viewFlipper.setOutAnimation(activity, R.anim.next_out)
            viewFlipper.showNext()
        }

        //previous beer button
        buttonPrevious.setOnClickListener {
            if(imageIndex <= 0){
                imageIndex = 3
            }else{
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