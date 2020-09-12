package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var view: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.actionPlus.setOnClickListener{ execute('+') }

        view.actionMinus.setOnClickListener{ execute('-')}

        view.actionMultiply.setOnClickListener{ execute('*') }

        view.actionDivide.setOnClickListener{ execute('/') }


    }
    fun execute(operation:Char) {
        view.resultOutputWidget.text = ""
        if(view.firstNumber.text.toString() == ""||view.secondNumber.text.toString() == ""){
            val toast =Toast.makeText(applicationContext, "Fill both fields!", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
            return
        }
        var result = 0.0
        val first = view.firstNumber.text.toString().toDouble()
        val second = view.secondNumber.text.toString().toDouble()
        when {
            operation.equals('*') -> {
                result = first * second
            }
            operation.equals('+') -> {
                result = first + second
            }
            operation.equals('-') -> {
                result = first - second
            }
            operation.equals('/') -> {
                if(view.secondNumber.text.toString().toDouble()==0.0){
                    val toast =Toast.makeText(applicationContext, "Cannot divide by 0!", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER,0,0)
                    toast.show()
                    return
                }
                result = first / second
            }
        }
        view.resultOutputWidget.text = result.toString()
    }

}
