package com.example.splmeet_search

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import com.example.splmeet_search.R

class Payd_dialog(context: Context, private val dialogClickListener: DialogClickListener) : Dialog(context) {

    interface DialogClickListener {
        fun onDeleteClick()
        fun onCancelClick()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_payd_dialog)

        window?.setBackgroundDrawableResource(android.R.color.transparent)

        val deleteButton = findViewById<Button>(R.id.ok)
        val cancelButton = findViewById<Button>(R.id.cancel)

        // 커스텀 다이얼로그 버튼 클릭 리스너 설정
        deleteButton.setOnClickListener {
            // 삭제 버튼 클릭 시 처리할 작업
            dialogClickListener.onDeleteClick()
            dismiss()
        }

        cancelButton.setOnClickListener {
            // 취소 버튼 클릭 시 처리할 작업
            dialogClickListener.onCancelClick()
            dismiss()
        }
    }
}
