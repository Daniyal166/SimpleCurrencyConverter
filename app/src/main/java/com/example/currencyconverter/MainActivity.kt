package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import kotlin.reflect.KFunction1

class MainActivity : AppCompatActivity() {

    fun usd(x:Double):Double{
        return x/186
    }
    fun inr(x:Double):Double{
        return x/2.43
    }
    fun euro(x:Double):Double{
        return x/196.04
    }
    fun aed(x:Double):Double{
        return x/50.52
    }
    fun decideFunction(operator:String): KFunction1<Double, Double> {
        if(operator=="USD"){
            return ::usd
        }
        else if(operator=="INR"){
            return ::inr
        }
        else if(operator=="EURO") {
            return ::euro
        }
        else{
            return ::aed
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num:EditText = findViewById(R.id.editTextNumber)
        val answer:TextView = findViewById(R.id.ans)
        val usd:RadioButton = findViewById(R.id.usd)
        val inr:RadioButton = findViewById(R.id.inr)
        val euro:RadioButton = findViewById(R.id.euro)
        val aed:RadioButton = findViewById(R.id.aed)
        usd.setOnClickListener {
            val func = decideFunction("USD")
            if(TextUtils.isEmpty(num.text)){
                answer.text = "Please enter Pkr Amount"
            }
            else {
                val anss = func(num.text.toString().toDouble())
                answer.text = anss.toString()
            }
            inr.isChecked=false
            euro.isChecked=false
            aed.isChecked=false
        }
        inr.setOnClickListener {
            val func = decideFunction("INR")
            if(TextUtils.isEmpty(num.text)){
                answer.text = "Please enter Pkr Amount"
            }
            else {
                val anss = func(num.text.toString().toDouble())
                answer.text = anss.toString()
            }
            usd.isChecked=false
            euro.isChecked=false
            aed.isChecked=false
        }
        euro.setOnClickListener {
            val func = decideFunction("EURO")
            if(TextUtils.isEmpty(num.text)){
                answer.text = "Please enter Pkr Amount"
            }
            else {
                val anss = func(num.text.toString().toDouble())
                answer.text = anss.toString()
            }
            inr.isChecked=false
            usd.isChecked=false
            aed.isChecked=false
        }
        aed.setOnClickListener {
            val func = decideFunction("AED")
            if(TextUtils.isEmpty(num.text)){
                answer.text = "Please enter Pkr Amount"
            }
            else {
                val anss = func(num.text.toString().toDouble())
                answer.text = anss.toString()
            }
            inr.isChecked=false
            euro.isChecked=false
            usd.isChecked=false
        }
    }
}