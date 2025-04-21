package vcmsa.daniel.mathapp

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstValue = findViewById<EditText>(R.id.firstValue)
        val answerButton = findViewById<Button>(R.id.answerButton)
        val secondValue = findViewById<EditText>(R.id.secondValue)
        val outputMessage = findViewById<TextView>(R.id.outputMessage)
        val  addition = findViewById<RadioButton>(R.id.additionButton)
        val  subtraction = findViewById<RadioButton>(R.id.subtractionButton)
        val  multiplication = findViewById<RadioButton>(R.id.multiplicationButton)
        val  division = findViewById<RadioButton>(R.id.divisionButton)
        var answer = 0




        answerButton.setOnClickListener {
            //checks if the edit text boxes are empty
            if (firstValue.text.isEmpty()) {
                outputMessage.text = ("Please enter a whole number in the first value box")
                return@setOnClickListener
            } else if (secondValue.text.isEmpty()) {
                outputMessage.text = ("Please enter a whole number in the second value box")
                return@setOnClickListener
            }
            //checks if the edit text boxes contain a decimal
            else if (firstValue.text.toString().contains(".")) {
                outputMessage.text = ("Decimal numbers are not allowed, Please enter a whole number in the first value box.")
                return@setOnClickListener
            }
            else if (secondValue.text.toString().contains(".")){
                outputMessage.text = ("Decimal numbers are not allowed, Please enter a whole number in the second value box.")
                return@setOnClickListener
            }
            //checks if the edit text boxes contain letters or symbols
            else if (firstValue.text.toString().toIntOrNull() == null) {
                outputMessage.text = ("Letters and symbols are not allowed, Please enter a number in the first value box.")
                return@setOnClickListener
            }
            else if (secondValue.text.toString().toIntOrNull() == null) {
                outputMessage.text = ("Letters and symbols are not allowed, Please enter a number in the second value box.")
                return@setOnClickListener
            }
            //checks if the edit text boxes contain a value less than 0
            else if (firstValue.text.toString().toInt() < 0) {
                outputMessage.text = ("Negative numbers are not allowed, Please enter a positive number in the first value box.")
                return@setOnClickListener
            }
            else if (secondValue.text.toString().toInt() < 0) {
                outputMessage.text = ("Negative numbers are not allowed, Please enter a positive number in the second value box.")
                return@setOnClickListener
            }
            //if all conditions are passed the answer is calculated and displayed to the user
            else {
                var firstNumber = (firstValue.text.toString().toInt())
                var secondNumber = (secondValue.text.toString().toInt())

                if (addition.isChecked == false && subtraction.isChecked == false && multiplication.isChecked == false && division.isChecked == false) {
                    outputMessage.text = ("Please select a mathematical operation.")
                    return@setOnClickListener
                }
                else
                    if (addition.isChecked) {
                        answer = firstNumber + secondNumber
                        outputMessage.text = ("You've chosen to add $firstNumber by $secondNumber")
                    } else if (subtraction.isChecked) {
                        answer = firstNumber - secondNumber
                        outputMessage.text = ("You've chosen to subtract $firstNumber by $secondNumber")
                    } else if (multiplication.isChecked) {
                        answer = firstNumber * secondNumber
                        outputMessage.text = ("You've chosen to multiply $firstNumber by $secondNumber")
                    } else if (division.isChecked) {
                        answer = firstNumber / secondNumber
                        outputMessage.text = ("You've chosen to divide $firstNumber by $secondNumber")
                    }
                    outputMessage.text = ("The answer is $answer")












            }
        }
    }
}