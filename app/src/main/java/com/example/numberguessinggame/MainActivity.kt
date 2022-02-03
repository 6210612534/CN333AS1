package com.example.numberguessinggame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var text:TextView
    lateinit var guess:EditText
    lateinit var hint:TextView
    lateinit var button:Button

    var random: Int = Random.nextInt(1,1000)
    var result: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.Text)
        guess = findViewById(R.id.Guess)
        hint = findViewById(R.id.Hint)
        button = findViewById(R.id.button)

        button.setOnClickListener{
            if(result){
                if(guess.text.isNotEmpty()){
                    hint.setTextColor(Color.rgb(32,122,174))

                    val num: Int = guess.text.toString().toInt()

                    if (num >= random) {
                        if (num > random) {
                            hint.text = "Hint: It's lower!"
                            guess.text.clear()

                        } else {
                            text.setTextColor(Color.rgb(47,137,14))
                            text.text =
                                "Congratulation!, your answer is correct!"
                            hint.text = "Click play again to start a new game"
                            guess.text.clear()
                            result = false
                        }
                    } else {
                        hint.text = "Hint: It's higher!"
                        guess.text.clear()

                    }
                }
                else{
                    hint.text = "Please enter your answer"
                    hint.setTextColor(Color.rgb(209,45,45))
                }
            }
            else{
                reset()
            }
        }
    }

    fun reset(){
        random = Random.nextInt(1, 1000)
        text.setTextColor(Color.BLACK)
        text.text = "Try to guess thee number I'm thinking of from 1 - 1000!"
        hint.text = ""
        guess.text.clear()
        result = true
    }
}