package com.example.marlon.prueba

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marlon.prueba.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CategoryAdapter
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = CategoryAdapter {
            val intent = Intent(this, DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putString("key1", it)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.recycler.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }

        getCategories()
    }


    fun getCategories() {
        viewModel.getCategories().observe(this) {
            it.value?.apply {
                CoroutineScope(Dispatchers.Default).let {
                    adapter.dataHasChanged(this)
                }
            }
        }
    }
}