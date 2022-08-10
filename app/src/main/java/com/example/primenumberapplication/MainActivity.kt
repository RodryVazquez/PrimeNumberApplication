package com.example.primenumberapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primenumberapplication.databinding.ActivityMainBinding
import com.example.primenumberapplication.view.PrimeNumberAdapter
import com.example.primenumberapplication.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    private var primeNumberAdapter: PrimeNumberAdapter? = null

    private var pageStartIndex = 0
    private var size = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecyclerView(binding.primeNumbersRecyclerView)
        viewModel.fetchPrimeNumbers(pageStartIndex, size)
    }

    override fun onResume() {
        super.onResume()
        observeViewModel()
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        primeNumberAdapter = PrimeNumberAdapter(arrayListOf())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = primeNumberAdapter
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount =
                    (recyclerView.layoutManager as LinearLayoutManager).childCount
                val totalItemCount = (recyclerView.layoutManager as LinearLayoutManager).itemCount
                val firstVisibleItemPosition: Int =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {

                    pageStartIndex = size + 1
                    size += size
                    viewModel.fetchPrimeNumbers(pageStartIndex, size)
                }
            }
        })
    }

    private fun observeViewModel() {
        viewModel.listPrimeNumbers.observe(this) { primeList ->
            if (primeList.isNotEmpty()) {
                primeNumberAdapter?.updatePrimeNumberList(primeList)
            }
        }
    }
}