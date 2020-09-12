package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var view: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)



        view.actionPlus.setOnClickListener{ if(onAnyActionClick()){
            view.resultOutputWidget.text = (view.firstNumber.text.toString().toDouble() + view.secondNumber.text.toString().toDouble()).toString() }}

        view.actionMinus.setOnClickListener{ if(onAnyActionClick()){
            view.resultOutputWidget.text = (view.firstNumber.text.toString().toDouble() - view.secondNumber.text.toString().toDouble()).toString() }}

        view.actionMultiply.setOnClickListener{ if(onAnyActionClick()){
            view.resultOutputWidget.text = (view.firstNumber.text.toString().toDouble() * view.secondNumber.text.toString().toDouble()).toString() }}

        view.actionDivide.setOnClickListener{ if(onAnyActionClick()){
            if(view.secondNumber.text.toString().toDouble()==0.0){
                view.divideByZeroWarning.visibility = View.VISIBLE
            }
            else
                view.resultOutputWidget.text = (view.firstNumber.text.toString().toDouble() / view.secondNumber.text.toString().toDouble()).toString()
        }}



    }
    fun onAnyActionClick(): Boolean{
        view.resultOutputWidget.text = ""
        view.divideByZeroWarning.visibility = View.INVISIBLE
        view.firstNumberEmptyWarning.visibility = View.INVISIBLE
        view.secondNumberEmptyWarning.visibility = View.INVISIBLE
        var bool = true
        if(view.firstNumber.text.toString() == ""){
            view.firstNumberEmptyWarning.visibility = View.VISIBLE
            bool = false
        }
        if(view.secondNumber.text.toString() == ""){
            view.secondNumberEmptyWarning.visibility = View.VISIBLE
            bool = false
        }
        return bool
    }

}
