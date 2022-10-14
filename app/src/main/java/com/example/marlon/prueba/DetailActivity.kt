package com.example.marlon.prueba

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.marlon.prueba.databinding.ActivityDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    var category: String? = null
    val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val bundle = intent.extras
        category= bundle?.getString("key1", "")
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getDetails()
    }

    fun getDetails() {
        viewModel.getCategoryDetails(category ?: "").observe(this) {
            it.value?.apply {
                binding.createdAt.text = createdAt
                binding.updatedAt.text = updatedAt
                binding.description.text = value
            }
        }
    }
}