package com.mvvm.flows.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.flows.databinding.ActivityMainBinding
import com.mvvm.flows.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        bindViews()
    }

    private fun setupViewModel() {
        mViewModel.names.observe(this) {
            if (it != null && it.isNotEmpty()) {
                mViewModel.updateNamesList(it)
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun bindViews() {
        binding.progressBar.visibility = View.VISIBLE
        with(binding.recyclerView) {
            adapter = mViewModel.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}