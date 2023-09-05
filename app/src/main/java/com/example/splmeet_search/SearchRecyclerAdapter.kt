package com.example.splmeet_search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splmeet_search.databinding.SearchItemBinding

class SearchRecyclerAdapter (private val itemList: List<SearchData>):RecyclerView.Adapter<SearchRecyclerAdapter.MyViewHolder>(){
    inner class MyViewHolder(private val binding: SearchItemBinding):RecyclerView.ViewHolder(binding.root){
        private val context=binding.root.context

        fun bind(item: SearchData){
            binding.data=item
            itemView.setOnClickListener {
                val intent = Intent(context, place_info::class.java)
                intent.putExtra("data", item)
                intent.run { context.startActivity(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder{
        val inflater=LayoutInflater.from(parent.context)
        val listItemBinding=SearchItemBinding.inflate(inflater,parent,false)
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}