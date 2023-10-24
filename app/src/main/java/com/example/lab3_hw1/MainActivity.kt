package com.example.lab3_hw1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)

        btn_mora.setOnClickListener { view: View? ->
            if (ed_name.length() < 1) {
                tv_text.text = "請輸入玩家姓名"
            } else {
                tv_name.text = String.format("名字\n%s", ed_name.text.toString())
                if (btn_scissor.isChecked) {
                    tv_mmora.text = "我方出拳\n剪刀"
                } else if (btn_stone.isChecked) {
                    tv_mmora.text = "我方出拳\n石頭"
                } else {
                    tv_mmora.text = "我方出拳\n布"
                }
                val computer_random = (Math.random() * 3).toInt()
                if (computer_random == 0) {
                    tv_cmora.text = "電腦出拳\n剪刀"
                } else if (computer_random == 1) {
                    tv_cmora.text = "電腦出拳\n石頭"
                } else {
                    tv_cmora.text = "電腦出拳\n布"
                }
                if (btn_scissor.isChecked && computer_random == 2 ||
                    btn_stone.isChecked && computer_random == 0 ||
                    btn_paper.isChecked && computer_random == 1
                ) {
                    tv_winner.text = """
                        勝利者
                        ${ed_name.text}
                        """.trimIndent()
                    tv_text.text = "恭喜您獲勝了! ! !"
                } else if (btn_scissor.isChecked && computer_random == 1 ||
                    btn_stone.isChecked && computer_random == 2 ||
                    btn_paper.isChecked && computer_random == 0
                ) {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "可惜，電腦獲勝了!"
                } else {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局，請在試一次!"
                }
            }
        }
    }
}