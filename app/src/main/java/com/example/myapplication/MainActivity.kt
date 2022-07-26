package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
            
    lateinit var diceImage : ImageView
    lateinit var numberTxt : TextView
    lateinit var nameTxt: EditText
    lateinit var playerName : TextView

    private val bindingPlayerName: GameInfo = GameInfo("Ready Player One?")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.gameInfo = bindingPlayerName
//        diceImage = findViewById(R.id.imageView)
//        numberTxt = findViewById(R.id.textView)
//        nameTxt = findViewById(R.id.nameTxt)
//        playerName = findViewById(R.id.PlayerName)

//        val rollBtn:Button = findViewById(R.id.roll)
//        rollBtn.setOnClickListener {rollDice()}
//
//        val updateBtn: Button = findViewById(R.id.nameButton)
//        updateBtn.setOnClickListener{ updateName(it)}
        binding.roll.setOnClickListener{rollDice()}
        binding.nameButton.setOnClickListener{updateName(it)}
    }

    private fun updateName(view : View){

//        binding.apply{
//            binding.PlayerName.text = binding.nameTxt.text
//            binding.PlayerName.clearComposingText()
//        }

        binding.PlayerName.text = binding.nameTxt.text

        binding.nameTxt.text.clear()
        binding.nameTxt.clearFocus()

        val inm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)

        binding.nameTxt.visibility = View.GONE
        binding.nameButton.visibility = View.GONE
    }


    private fun rollDice(){
        val randNum = (1..6).random()
    //    val numberTxt : TextView = findViewById(R.id.textView)
//        numberTxt.text = randNum.toString()

    //    val diceImage : ImageView = findViewById(R.id.imageView)
        val imageSrc = when(randNum){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.textView.text = randNum.toString()
        binding.imageView.setImageResource(imageSrc)
//        diceImage.setImageResource(imageSrc)

    }
}