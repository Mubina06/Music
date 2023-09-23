package com.example.musicapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicapp.R
import com.example.musicapp.adapter.FirstAdapter
import com.example.musicapp.databinding.FragmentFirstBinding
import com.example.musicapp.model.Music


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var FirstAdapter: FirstAdapter
lateinit var listItem: MutableList<Music>


class FirstFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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

        var binding = FragmentFirstBinding.inflate(inflater)

        listItem = mutableListOf<Music>()
        listItem.add(Music(R.drawable.img, "Music", "Author", R.raw.music))
        listItem.add(Music(R.drawable.img, "Music", "Author", R.raw.music))
        listItem.add(Music(R.drawable.img, "Music", "Author", R.raw.music))
        listItem.add(Music(R.drawable.img, "Music", "Author", R.raw.music))
        listItem.add(Music(R.drawable.img, "Music", "Author", R.raw.music))
        listItem.add(Music(R.drawable.img, "Music", "Author", R.raw.music))


        FirstAdapter = FirstAdapter(listItem, this)
        binding.rv1.adapter = FirstAdapter

        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}