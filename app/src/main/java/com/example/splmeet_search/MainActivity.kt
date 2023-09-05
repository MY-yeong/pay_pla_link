package com.example.splmeet_search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.splmeet_search.databinding.ActivityMainBinding
import com.example.splmeet_search.ui.theme.Splmeet_searchTheme
import java.sql.Savepoint

class MainActivity:AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mActionBar=supportActionBar
        mActionBar!!.hide()

        var data=listOf(SearchData("2023. 07. 01 (토)","에버랜드","42,000원"),
            SearchData("2023. 07. 02 (일)","애벌랜드","10,000원"),
            SearchData("엘리시움","test2","test2"),
            SearchData("2023. 07. 04 (화)","test2","test2"),
            SearchData("마라탕","test2","test2"),
            SearchData("test2","test2","test2"),
            SearchData("test2","test2","test2"),
            SearchData("고기","test2","test2"),
            SearchData("test2","test2","test2"),
            SearchData("test2","test2","test2"),
            SearchData("갈비","test2","test2"),
        )

        binding.recyclerView.apply{
            adapter=SearchRecyclerAdapter(data)
        }
    }
}