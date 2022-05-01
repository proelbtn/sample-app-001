package com.proelbtn.sampleapp001

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proelbtn.sampleapp001.adapters.StoreAdapter
import com.proelbtn.sampleapp001.viewmodels.StoreViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: StoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.stores.collect {
                    Timber.d("stores downloaded, displaying stores")

                    val storesView: RecyclerView = findViewById(R.id.list_stores)
                    val layoutManager = LinearLayoutManager(applicationContext)
                    val adapter = StoreAdapter(it)

                    storesView.layoutManager = layoutManager
                    storesView.adapter = adapter
                    storesView.addItemDecoration(DividerItemDecoration(applicationContext, layoutManager.orientation))

                    adapter.notifyDataSetChanged()
                }
            }
        }

        findViewById<Button>(R.id.button_download).setOnClickListener {
            Timber.d("download button clicked, fetching stores")
            viewModel.fetchShop()
        }
    }
}
