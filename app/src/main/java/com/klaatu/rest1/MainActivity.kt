package com.klaatu.rest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.koushikdutta.ion.Ion
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun todoClick(view: View){
        Ion.with(this)
            .load("https://jsonplaceholder.typicode.com/todos/1")
            .asString()
            .setCallback({e,result->
                Log.d("Muestra","Resultado JSON is\n$result")
                processTodoData(result)
            })
    }

fun processTodoData(result:String){
    val json = JSONObject(result)
    val title = json.getString("title")
    val completed = json.getString("completed")
    todoTitle.text=title
    todoCompleted.text=completed
}

}