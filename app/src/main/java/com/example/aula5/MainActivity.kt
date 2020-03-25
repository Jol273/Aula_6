package com.example.aula5

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.*


class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private val VISOR_KEY = "visor"

    @RequiresApi(Build.VERSION_CODES.N)
    var text = SimpleDateFormat("HH:mm:ss").format(Date())
    private val duration = Toast.LENGTH_SHORT
    var lastExpression = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"o método onCreate foi invocado")
        setContentView(R.layout.activity_main)

        button_ce.setOnClickListener{
                Log.i(TAG,"Click no botão C")
                onClickClean()
                val toast = Toast.makeText(this, "$text button_clear", duration)
                toast.show()
            }

        button_backspace.setOnClickListener{
            onClickBackspace()
        }

        button_division.setOnClickListener{
            Log.i(TAG, "Click no botão !")
            val toast = Toast.makeText(this, "$text button_division", duration)
            toast.show()
            //text_visor.append("!")
        }

        button_multiplication.setOnClickListener {
            Log.i(TAG,"Click no botão *")
            val toast = Toast.makeText(this, "$text button_multiplication", duration)
            toast.show()
            //text_visor.append("?")
        }

        button_minus.setOnClickListener {
            Log.i(TAG,"Click no botão -")
            val toast = Toast.makeText(this, "$text button_minus", duration)
            toast.show()
            //text_visor.append("#")
        }

        button_4.setOnClickListener{
            Log.i(TAG,"Click no botão 4")
            onClickSymbol("4")
            val toast = Toast.makeText(this, "$text button_4", duration)
            toast.show()
        }

        button_5.setOnClickListener{
            Log.i(TAG,"Click no botão 5")
            onClickSymbol("5")
            val toast = Toast.makeText(this, "$text button_5", duration)
            toast.show()
        }

        button_6.setOnClickListener{
            Log.i(TAG,"Click no botão 6")
            onClickSymbol("6")
            val toast = Toast.makeText(this, "$text button_6", duration)
            toast.show()
        }

        button_1.setOnClickListener{
            Log.i(TAG,"Click no botão 1")
            onClickSymbol("1")
            val toast = Toast.makeText(this, "$text button_1", duration)
            toast.show()
        }

        button_2.setOnClickListener{
            Log.i(TAG,"Click no botão 2")
            onClickSymbol("2")
            val toast = Toast.makeText(this, "$text button_2", duration)
            toast.show()
        }

        button_3.setOnClickListener{
            Log.i(TAG,"Click no botão 3")
            onClickSymbol("3")
            val toast = Toast.makeText(this, "$text button_3", duration)
            toast.show()
        }

        button_adition.setOnClickListener{
            Log.i(TAG, "Click no botão +")
            onClickSymbol("+")
            val toast = Toast.makeText(this, "$text button_adition", duration)
            toast.show()
        }

        button_0.setOnClickListener{
            Log.i(TAG,"Click no botão 0")
            onClickSymbol("0")
            val toast = Toast.makeText(this, "$text button_0", duration)
            toast.show()
        }

        button_dot.setOnClickListener{
            Log.i(TAG,"Click no botão .")
            onClickSymbol(".")
            val toast = Toast.makeText(this, "$text button_dot", duration)
            toast.show()
        }

        button_equals.setOnClickListener {
            lastExpression = text_visor.text.toString()
            Log.i(TAG,"Click no botão =")
            onClickEquals()
            val toast = Toast.makeText(this, text + " button_equals", duration)
            toast.show()
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run { putString(VISOR_KEY, text_visor.text.toString()) }
        super.onSaveInstanceState(outState)

    }

    private fun onClickSymbol(symbol: String){
        if(text_visor.text == "0"){
            text_visor.text = symbol
        } else {
            text_visor.append(symbol)
        }
    }

    private fun onClickEquals(){
        lastExpression = text_visor.text.toString()
        Log.i(TAG,"Click no botão =")
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        text_visor.text = expression.evaluate().toString()
        Log.i(TAG, "O resultado da expressão é ${text_visor.text}")
        val toast = Toast.makeText(this, "$text button_equals", duration)
        toast.show()
    }

    private fun onClickClean(){
        Log.i(TAG,"Click no botão C")
        text_visor.text = "0"
        //text_visor.clearComposingText()
        val toast = Toast.makeText(this, "$text button_clear", duration)
        toast.show()
    }

    private fun onClickBackspace(){
        Log.i(TAG,"Click no botão >")
        var str = text_visor.text
        if(str.length > 1){
            str = str.substring(0,str.length - 1)
            text_visor.text = str
        }else if(str.length <= 1){
            text_visor.text = "0"
        }
        val toast = Toast.makeText(this, "$text button_backspace", duration)
        toast.show()
    }

    override fun onDestroy() {
        Log.i(TAG,"o método onDestroy foi invocado")
        super.onDestroy()
    }


}

// dentro do onCreate
/*
button_last.setOnClickListener {
            onClickLast()
            val toast = Toast.makeText(this, "$text button_last", duration)
            toast.show()
        }
*/

/*private fun onClickLast(){
        Log.i(TAG,"Click no botão Ultima Conta")
        text_visor.text = lastExpression
    }*/
