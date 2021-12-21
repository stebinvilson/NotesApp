package com.example.notesapp.Ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.notesapp.databinding.RegisterfragmentBinding
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Viewmodels.UserViewmodel
import com.example.notesapp.Model.UserEntity


class RegisterFragment : Fragment() {



    private  var _binding : RegisterfragmentBinding? = null

    private val binding get()= _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterfragmentBinding.inflate(inflater,container,false)
        val viewmodel: UserViewmodel by activityViewModels()
            ViewModelProvider(requireActivity()).get(UserViewmodel::class.java)



        binding.regRegister.setOnClickListener(View.OnClickListener {
            var user = UserEntity(0,
                binding.regEdUsername.text.toString(),binding.regEdEmail.text.toString(),binding.regEdPassword.text.toString())
            viewmodel.adduser(user)
        })

        val view = binding.root
        return view
    }
}