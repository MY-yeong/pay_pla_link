package com.example.splmeet_search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.splmeet_search.databinding.ActivityNoticeDetailBinding

class NoticeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoticeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<SearchData>("data")

        binding.detailName.text = data!!.date
        binding.detailIntro.text = data!!.place
        binding.detailPrice.text = data!!.price


    }
}