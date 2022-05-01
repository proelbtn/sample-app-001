package com.proelbtn.sampleapp001

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.proelbtn.sampleapp001.databinding.FragmentStoreDetailBinding
import com.proelbtn.sampleapp001.viewmodels.StoreViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StoreDetailFragment: Fragment() {
    @Inject
    lateinit var picasso: Picasso

    private lateinit var binding: FragmentStoreDetailBinding
    private val viewModel: StoreViewModel by activityViewModels()
    private val args: StoreDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreDetailBinding.inflate(inflater, container, false)

        val store = viewModel.findStoreById(args.storeId)
        if (store != null) {
            binding.name = store.title
            binding.description = store.description
            picasso.load(store.image)
                .into(binding.storeImage)
        }

        return binding.root
    }
}
