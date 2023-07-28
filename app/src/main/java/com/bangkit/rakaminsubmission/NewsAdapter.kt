package com.bangkit.rakaminsubmission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.rakaminsubmission.databinding.ItemNewsBinding

class NewsAdapter : PagingDataAdapter<ArticlesItem, NewsAdapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = getItem(position)
        news?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: ItemNewsBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(news : ArticlesItem){

        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticlesItem>() {
            override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}