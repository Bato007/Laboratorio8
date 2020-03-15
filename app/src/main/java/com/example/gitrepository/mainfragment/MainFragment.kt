@file:Suppress("DEPRECATION")
package com.example.gitrepository.mainfragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.gitrepository.R
import com.example.gitrepository.databinding.MainFragmentBinding

/**
 * A simple [Fragment] subclass.
 */

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.main_fragment, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        // Busca el username
        binding.searchButton.setOnClickListener {
            if(viewModel.flag == true){
                Toast.makeText(this.activity, "Did find this user", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this.activity, "Didn't find this user", Toast.LENGTH_SHORT).show()
            }
        }

        // Los manda a las listas
        binding.seeRepository.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_repositoryFragment)
        }

        return binding.root
    }

}
