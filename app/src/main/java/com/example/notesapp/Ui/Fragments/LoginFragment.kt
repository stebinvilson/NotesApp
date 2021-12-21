package com.example.notesapp.Ui.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.notesapp.R
import com.example.notesapp.Ui.Activity.MainActivity
import com.example.notesapp.Viewmodels.UserViewmodel
import com.example.notesapp.databinding.LoginfragmentBinding

class LoginFragment : Fragment() {

    private var _binding : LoginfragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LoginfragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        val viewmodel: UserViewmodel by activityViewModels()
        binding.btnRegister.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        })

        viewmodel.empList.observe(this, Observer {
            val employeeData = it
            // setdata(employeeData)

        })

        viewmodel.loggeduser?.observe(this, Observer {
            var success = it
            if(success != null) {
                val intent = Intent(activity,MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(activity,"some error",Toast.LENGTH_LONG).show()
            }

        })

        binding.btnLogin.setOnClickListener(View.OnClickListener {
             viewmodel.checkuser(binding.edUsername.text.toString(),binding.edPassword.text.toString())
        })
        return view
    }
}