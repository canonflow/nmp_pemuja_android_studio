package com.pemujaandroidstudio.esportcompanyprofileapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pemujaandroidstudio.esportcompanyprofileapp.databinding.FragmentWhoWeAreBinding
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class WhoWeAreFragment : Fragment() {
    private lateinit var binding:FragmentWhoWeAreBinding

    companion object {
        private var LIKE: Int = 15
        private var IS_LIKED: Boolean = false

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WhoWeAreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // Retrieve any arguments passed via `newInstance`
            val param1 = it.getString(ARG_PARAM1)
            val param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWhoWeAreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.likeCounter.text = LIKE.toString()

        if (IS_LIKED) {
            binding.btnLike.isEnabled = false
            binding.btnLike.isClickable = false
        }

        binding.btnLike.setOnClickListener {
            LIKE++
            IS_LIKED = true
            binding.btnLike.isEnabled = false
            binding.btnLike.isClickable = false
            binding.likeCounter.text = LIKE.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
