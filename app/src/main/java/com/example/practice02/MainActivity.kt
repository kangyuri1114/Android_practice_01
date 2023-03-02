package com.example.practice02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//레이아웃의 액티비티 메인 xml파일을 불러옴

        val tv: TextView = findViewById(R.id.tv_hello)
        val btn: Button = findViewById(R.id.btn_kor)

        //버튼에 기능넣기
        btn.setOnClickListener {
            tv.text = "안녕"//텍스트를 붙이면 위젯의 내용을 선택할 수 있음
        }

//        val textView: TextView = findViewById(R.id.android_text) as TextView //변수 선언
//        //val textView: TextView 에서 : TextView 는 textView가 어떤 객체인지 설명해주는
//        textView.setOnClickListener {
//            textView.text = getString(R.string.name) //문자열을 받아와라

    }
}