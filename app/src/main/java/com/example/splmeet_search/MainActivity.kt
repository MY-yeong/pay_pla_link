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

        var data=listOf(SearchData("test","test","test","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("엘리시움","test2","test2","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("마라탕","test2","test2","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("고기","test2","test2","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("갈비","test2","test2","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("test2","test2","test2","test"),
            SearchData("test2","test2","test2","test")
        )

        binding.recyclerView.apply{
            adapter=SearchRecyclerAdapter(data)
        }
    }
}