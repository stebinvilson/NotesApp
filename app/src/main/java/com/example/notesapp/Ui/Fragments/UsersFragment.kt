package com.example.notesapp.Ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesapp.databinding.UsersfragmentBinding

class UsersFragment : Fragment() {

    private var _binding : UsersfragmentBinding? = null
    private val binding = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = UsersfragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }
}