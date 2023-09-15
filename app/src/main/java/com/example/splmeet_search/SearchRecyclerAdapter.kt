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

            binding.xwindow.setOnClickListener {
                val customDialog = Payd_dialog(context, object : Payd_dialog.DialogClickListener {
                    override fun onDeleteClick() {
                        // 삭제 버튼 클릭 시 처리할 작업
                        // 예: 결제 내역 삭제 동작
                        itemList.drop(adapterPosition) // 현재 아이템 제거
                        notifyDataSetChanged() // 어댑터 갱신
                    }

                    override fun onCancelClick() {
                        // 취소 버튼 클릭 시 처리할 작업
                        // 예: 다이얼로그 닫기
                    }
                })

                // 커스텀 다이얼로그 표시
                customDialog.show()
            }

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