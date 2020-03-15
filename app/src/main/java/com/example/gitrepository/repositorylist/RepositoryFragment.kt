@file:Suppress("DEPRECATION")

package com.example.gitrepository.repositorylist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.gitrepository.R
import com.example.gitrepository.databinding.RepositoryListFragmentBinding
import com.example.gitrepository.mainfragment.MainViewModel

/**
 * A simple [Fragment] subclass.
 */
class RepositoryFragment : Fragment() {

    private lateinit var binding: RepositoryListFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.repository_list_fragment, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner

        setHasOptionsMenu(true)
        return binding.root
    }

    // Inicializando el menu para poder guardar las cosas
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.back_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        view!!.findNavController().navigate(R.id.action_repositoryFragment_to_mainFragment)
        return super.onOptionsItemSelected(item)
    }


}
