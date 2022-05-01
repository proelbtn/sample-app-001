package com.proelbtn.sampleapp001

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.proelbtn.sampleapp001.adapters.StoreAdapter
import com.proelbtn.sampleapp001.databinding.FragmentStoreListBinding
import com.proelbtn.sampleapp001.viewmodels.StoreViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class StoreListFragment : Fragment() {
    private val viewModel: StoreViewModel by activityViewModels()
    private lateinit var binding: FragmentStoreListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreListBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            viewModel.stores
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    Timber.d("stores downloaded, displaying stores")

                    val layoutManager = LinearLayoutManager(context)
                    val adapter = StoreAdapter(it)

                    binding.storesList.layoutManager = layoutManager
                    binding.storesList.adapter = adapter
                    binding.storesList.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))

                    adapter.notifyDataSetChanged()
                }
        }

        binding.downloadButton.setOnClickListener {
            Timber.d("download button clicked, fetching stores")
            viewModel.fetchShop()
        }

        return binding.root
    }
}
