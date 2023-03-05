package com.example.practice02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Math.abs
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    fun main(){
        setContentView(R.layout.activity_main)//리소스의 레이아웃의 액티비티 메인 xml파일(화면)을 불러옴
        var stage = 1 //isRunning을 지우고 stage1,2,3...으로 전환, stage 1은 초기값
        var sec: Int = 0 //기본 단위가 mmsec이므로 나누기 100을 해야 1초임
        var timerTask: Timer? = null  //nullable로 선언
        val tv_t: TextView = findViewById(R.id.tv_timer)
        val tv_r: TextView = findViewById(R.id.tv_random)
        val tv_p: TextView = findViewById(R.id.tv_point)
        val btn: Button = findViewById(R.id.btn_main)

        //랜덤 수 생성하기 박스 변수
        val random_box = java.util.Random() //변수
        val num = random_box.nextInt(1001) //11을 넣으면 0부터 10까지 정수로 반환
        tv_r.text = (num.toFloat() / 100).toString()
        btn.text = "시작"

        btn.setOnClickListener {
            stage++ //클릭 시 stage가 올라감
            if (stage == 2) {
                timerTask = timer(period = 10) { // period가 1000 mmsecond = 1초마다 함수가 돌아간다
                    //period가 10으로 설정, sec/100로 설정, sec의 자료형을 Int에서 float으로 변경 시 소수점까지 나오게 실행 가능
                    sec++
                    //UI를 바꾸기 위해서는 runOnUiThread를 사용해야 한다.
                    runOnUiThread { //실시간으로 화면을 바꾸기 위해 사용
                        tv_t.text = (sec.toFloat() / 100).toString() //자료형 바꿔주기
                    }
                    //println(sec)  //초가 흘러갈때마다 시스템 상 출력
                }
                btn.text = "정지"
            }
            else if(stage == 3){
                timerTask?.cancel()  //nullable
                val point = abs(sec-num).toFloat()/100 //절댓값 abs
                tv_p.text = point.toString()
                btn.text = "다음"
                stage = 0
            }
            else if(stage == 1){
                main()//재귀함수
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        main()
        super.onCreate(savedInstanceState)

    }
}
