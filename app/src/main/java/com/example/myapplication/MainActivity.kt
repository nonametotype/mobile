package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    lateinit var numberTxt : TextView
    lateinit var nameTxt: TextView
    lateinit var playerName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.imageView)
        numberTxt = findViewById(R.id.textView)
        nameTxt = findViewById(R.id.nameTxt)
        playerName = findViewById(R.id.PlayerName)

        val rollBtn:Button = findViewById(R.id.roll)
        rollBtn.setOnClickListener {rollDice()}

        val updateBtn: Button = findViewById(R.id.nameButton)
        updateBtn.setOnClickListener{ updateName(it)}

    }

    private fun updateName(view : View){
        playerName.text = nameTxt.text

    }

    private fun rollDice(){
        val randNum = (1..6).random()
    //    val numberTxt : TextView = findViewById(R.id.textView)
        numberTxt.text = randNum.toString()

    //    val diceImage : ImageView = findViewById(R.id.imageView)
        val imageSrc = when(randNum){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(imageSrc)
    }
}