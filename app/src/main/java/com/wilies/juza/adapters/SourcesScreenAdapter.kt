package com.wilies.juza.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wilies.juza.databinding.SourcesSingleItemBinding
import com.wilies.juza.interactions.SourceCardClickListener
import com.wilies.juza.network.SourceDTO

class SourcesScreenAdapter(private val clickListener: SourceCardClickListener): RecyclerView.Adapter<SourcesScreenAdapter.SourcesViewHolder>() {
    private var sourcesList = listOf<SourceDTO>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SourcesViewHolder {
        return SourcesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SourcesScreenAdapter.SourcesViewHolder, position: Int) {
        val source = sourcesList[position]
        holder.bind(source, clickListener)
    }

    override fun getItemCount() = sourcesList.size

    fun setSourcesList(sources: List<SourceDTO>){
        sourcesList = sources
        notifyDataSetChanged()
    }

    class SourcesViewHolder(private val binding: SourcesSingleItemBinding): RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): SourcesViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = SourcesSingleItemBinding.inflate(inflater, parent, false)
                return SourcesViewHolder(binding)
            }
        }

        fun bind(source: SourceDTO, clickListener: SourceCardClickListener){
            binding.source = source
            binding.clickListener = clickListener
        }

    }
}