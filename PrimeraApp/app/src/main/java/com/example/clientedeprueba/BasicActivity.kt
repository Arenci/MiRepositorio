package com.example.clientedeprueba

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import android.widget.EditText;
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_basic.*
import kotlinx.android.synthetic.main.content_basic.*

class BasicActivity : AppCompatActivity() {
    var valid = false

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        setSupportActionBar(toolbar)
        searchDog.setOnClickListener {
            validate()

        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)




    }
    private fun validate(){
        editTextBreed.setError(null)

        val breed = editTextBreed.getText().toString()
        if(TextUtils.isEmpty(breed)){
            editTextBreed.setError(getString(R.string.required_field))
            editTextBreed.requestFocus()

            return
        }else{
            valid = true
        }
        if (valid == true){
            requestToServer(breed)
        }

    }
    private fun requestToServer(breed: String){
        val queue = Volley.newRequestQueue(this)

        val url = "http://192.168.103.85:40000/dogs/$breed"


        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->

                resultText.text = "Breed: " + response.get("breed").toString() + System.getProperty ("line.separator") + "Name: " + response.get("name").toString()


            },
            Response.ErrorListener { error ->

            }
        )
        queue.add(jsonObjectRequest)
    }

}
