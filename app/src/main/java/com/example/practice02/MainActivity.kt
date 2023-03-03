package com.example.practice02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Math.abs
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//레이아웃의 액티비티 메인 xml파일을 불러옴
        var sec: Int = 0
        var isRunning = false //초기에 실행 되고 있지 않음
        var timerTask: Timer? = null  //nullable로 선언
        val tv_t: TextView = findViewById(R.id.tv_timer)
        val tv_r: TextView = findViewById(R.id.tv_random)
        val tv_p: TextView = findViewById(R.id.tv_point)


        val btn: Button = findViewById(R.id.btn_main)

        //랜덤 수 생성하기 박스 변수
        val random_box = java.util.Random()
        val num = random_box.nextInt(1001) //11을 넣으면 0부터 10까지 정수로 반환
        tv_r.text = (num.toFloat() / 100).toString()


        btn.setOnClickListener {
            isRunning = !isRunning //isRunning을 true로 바꾸어줌 클릭할때마다 false, true가 왔다갔다
            if (isRunning == true) {
                timerTask = timer(period = 10) { // period가 1000 mmsecond = 1초마다 함수가 돌아간다
                    //period가 10으로 설정, sec/100로 설정, sec의 자료형을 Int에서 float으로 변경 시 소수점까지 나오게 실행 가능
                    sec++
                    //UI를 바꾸기 위해서는 runOnUiThread를 사용해야 한다.
                    runOnUiThread { //실시간으로 화면을 바꾸기 위해 사용
                        tv_t.text = (sec.toFloat() / 100).toString() //자료형 바꿔주기
                    }
                    //println(sec)  //초가 흘러갈때마다 시스템 상 출력
                }
            } else {
                timerTask?.cancel()  //nullable
                val point = abs(sec-num).toFloat()/100 //절댓값 abs
                tv_p.text = point.toString()
            }

        }
    }
}
