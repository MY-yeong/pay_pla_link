package com.example.splmeet_search

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class place_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_info)

        val kakaokeymap: ImageButton = findViewById(R.id.kakaoMapButton)

        val back : ImageButton = findViewById(R.id.Bckbtn)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        kakaokeymap.setOnClickListener {
            val place_nm: TextView = findViewById(R.id.placename)
            val placeName = "${place_nm.text}" // 검색할 장소 이름을 여기에 입력하세요.
            // 카카오 맵 앱을 열고 주소를 검색합니다.
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("kakaomap://search?q=$placeName")

            // 카카오 맵 앱이 설치되어 있지 않을 경우 Play 스토어로 이동
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                val marketIntent = Intent(Intent.ACTION_VIEW)
                marketIntent.data = Uri.parse("market://details?id=net.daum.android.map")
                startActivity(marketIntent)
            }
        }

        val button = findViewById<Button>(R.id.planplus)
        val telEdit: TextView = findViewById(R.id.tel_edit)
        val telBtn: ImageButton = findViewById(R.id.tel_btn)

        button.setOnClickListener() {
            Toast
                .makeText(this, "일정이 추가되었습니다.", Toast.LENGTH_SHORT)
                .show()
        }

        telEdit.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        telBtn.setOnClickListener {
            val telNumber = "tel:${telEdit.text}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(telNumber))
            startActivity(intent)
        }

    }
}