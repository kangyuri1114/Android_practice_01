package com.example.practice02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//레이아웃의 액티비티 메인 xml파일을 불러옴

        var sec: Int = 0
        var isRunning = false //초기에 실행되고 있지 않음
        var timerTask: Timer? = null  //nullable로 선언
        val tv: TextView = findViewById(R.id.tv_hello)
        val btn: Button = findViewById(R.id.btn_kor)

        btn.setOnClickListener {
            isRunning = !isRunning //isRunning을 true로 바꾸어줌 클릭할때마다 false, true가 왔다갔다
            if (isRunning == true) {
                timerTask = timer(period = 1000) { // period가 1000 mmsecond = 1초마다 함수가 돌아간다
                    sec++
                    //UI를 바꾸기 위해서는 runOnUiThread를 사용해야 한다.
                    runOnUiThread { //실시간으로 화면을 바꾸기 위해 사용
                        tv.text = sec.toString() //자료형 바꿔주기
                    }
                    //println(sec)  //초가 흘러갈때마다 시스템 상 출력
                }
            } else {
                timerTask?.cancel()  //nullable
            }
        }


//        val textView: TextView = findViewById(R.id.android_text) as TextView //변수 선언
//        //val textView: TextView 에서 : TextView 는 textView가 어떤 객체인지 설명해주는
//        textView.setOnClickListener {
//            textView.text = getString(R.string.name) //문자열을 받아와라

    }
}