package com.example.labonabrewery.ui.aboutus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.labonabrewery.databinding.FragmentAboutUsBinding

class AboutUsFragment : Fragment() {

    private var _binding: FragmentAboutUsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView
        textView.text = "Craft je opet IN!"

        val textView2: TextView = binding.textView2
        textView2.text = "LABONA Premium Craft pivo za prave pivoljupce"

        val textView3: TextView = binding.textView3
        textView3.text =
            "Labona je nova pivovara iz Labina koja je osnovana 2021.g.od strane mladih entuzijasta koji su godinama stvarali pivo kod kuće samo za vlastite potrebe. Svoje iskustvo i ono što su jednom bili kućni uradci odlučili smo podijeliti sa širom publikom, te prenijeti svoje promišljanje i filozofiju stvaranja piva i guštanja u pivu.\n" +
                    System.getProperty("line.separator") +
                    "Svi naši proizvodi su potpuno prirodni bez ikakvih dodataka, surogata, aroma, bojila ili konzervansa, nefiltrirani su i nepasterizirani što jamči kvalitetu i pivo punog i specifičnog okusa koje zove na još jednu čašu.\n" +
                    System.getProperty("line.separator") +
                    "Važno je naglasiti da pivo koje stvaramo, radimo i dalje kao da je za nas osobno i želimo da zajedno sa nama uživate u novom pivskom doživljaju koji pružaju naša piva."
        return root
    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }
}