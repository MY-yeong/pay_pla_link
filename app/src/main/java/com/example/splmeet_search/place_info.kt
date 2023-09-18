package com.example.splmeet_search

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.template.model.LocationTemplate

class place_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_info)

        KakaoSdk.init(this, getString(R.string.kakao_app_key))

        val kakaokeymap: ImageButton = findViewById(R.id.kakaoMapButton)
        val imageUploadButton = findViewById<ImageButton>(R.id.kakaolink)

        // 이미지 버튼 클릭 이벤트 처리
        imageUploadButton.setOnClickListener {
            sendKakaoMessage(this)
        }

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

    private fun sendKakaoMessage(context: Context) {
        // Location 정보 설정

        val location = LocationTemplate.newBuilder(
            content = ContentObject.newBuilder(
                title = "카카오 맵에서 공유할 장소",
                description = "카카오 맵을 통해 확인하세요."
            ).setImageUrl("이미지 URL").setLink(
                LinkObject.newBuilder()
                    .setWebUrl("카카오 맵 웹 페이지 URL")
                    .setMobileWebUrl("카카오 맵 모바일 웹 페이지 URL")
            ).build()
        ).setAddress("장소 주소")
            .setAddressTitle("주소 타이틀")
            .setSocial(
                SocialObject.newBuilder()
                    .setLikeCount(10)
                    .setCommentCount(20)
                    .setSharedCount(30)
                    .setViewCount(40)
                    .build()
            )
            .build()

        // 카카오톡 메시지 템플릿 설정
        val template = DefaultTemplate.newBuilder(
            content = location,
            buttons = listOf(
                ButtonObject("웹에서 확인", LinkObject.newBuilder()
                    .setWebUrl("웹 페이지 URL")
                    .setMobileWebUrl("모바일 웹 페이지 URL")
                    .build()
                ),
                ButtonObject("앱에서 확인", LinkObject.newBuilder()
                    .setAndroidExecutionParams("안드로이드 앱 실행 파라미터")
                    .setIosExecutionParams("iOS 앱 실행 파라미터")
                    .build()
                )
            )
        ).build()

        // 카카오톡 메시지 전송
        TalkApiClient.instance.sendDefaultMessage(template, object : TalkResponseCallback<TalkMessageResponse>() {
            override fun onSuccess(result: TalkMessageResponse?) {
                // 메시지 전송 성공 시 처리
                Toast.makeText(context, "카카오톡 메시지가 전송되었습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(errorResult: ErrorResult?) {
                // 메시지 전송 실패 시 처리
                Toast.makeText(context, "카카오톡 메시지 전송 실패", Toast.LENGTH_SHORT).show()
            }
        })
    }





}