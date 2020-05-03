package com.example.calculator3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button0.setOnClickListener{setTextField("0")}
        button1.setOnClickListener{setTextField("1")}
        button2.setOnClickListener{setTextField("2")}
        button3.setOnClickListener{setTextField("3")}
        button4.setOnClickListener{setTextField("4")}
        button5.setOnClickListener{setTextField("5")}
        button6.setOnClickListener{setTextField("6")}
        button7.setOnClickListener{setTextField("7")}
        button8.setOnClickListener{setTextField("8")}
        button9.setOnClickListener{setTextField("9")}
        button_div.setOnClickListener{setTextField("/")}
        button_min.setOnClickListener{setTextField("-")}
        button_plus.setOnClickListener{setTextField("+")}
        button_mult.setOnClickListener{setTextField("*")}
        button_extra1.setOnClickListener{setTextField("(")}
        button_extra2.setOnClickListener{setTextField(")")}
        button_dot.setOnClickListener{setTextField(".")}
        button_c.setOnClickListener{
            operationField.text = ""
            resultField.text = ""
        }
        button_del.setOnClickListener{
            val str = operationField.text.toString()
            if(str.isNotEmpty()){
                operationField.text = str.substring(0, str.length-1)
                resultField.text = ""
            }

        }
        button_eq.setOnClickListener {
            try{
                    val ex = ExpressionBuilder(operationField.text.toString()).build()
                    val res = ex.evaluate()
                    val longRes = res.toLong()
                    if(res == longRes.toDouble())
                        resultField.text = longRes.toString()
                    else
                        resultField.text = res.toString()
                   }catch (e:Exception){
                Log.d("Error","Такие дела: ${e.message}")

            }

        }

    }
    fun setTextField(str:String){
        if(resultField.text !=""){
            operationField.text = resultField.text
            resultField.text =""
        }
        operationField.append(str)
    }
}
