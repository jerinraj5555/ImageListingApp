package com.hilt.ui.imagelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.hilt.ui.Utility
import com.hilt.ui.databinding.FragmentImageListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ImageListFragment : Fragment() {
    @Inject
    lateinit var adapter: ImageAdapter
    private var _binding: FragmentImageListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ImageListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageListBinding.inflate(inflater, container, false)
        //  binding.vm = viewModel
        //binding.lifecycleOwner = this
        binding.rlView.layoutManager = LinearLayoutManager(requireContext())
        binding.rlView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!Utility.hasNetworkAvailable(requireContext()))
            viewModel.fetchAllMovies()
        init()
    }

    private fun init() {
        viewModel.getAllMoviesListFromDb().asLiveData().observe(viewLifecycleOwner,
            {
                if (!it.isNullOrEmpty())
                    adapter.setList(it)
            })
    }


}