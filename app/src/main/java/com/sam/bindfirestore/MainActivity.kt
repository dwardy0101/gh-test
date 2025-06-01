package com.sam.bindfirestore

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson

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



       try {
           val fs = FirebaseFirestore.getInstance()

           fs.collection("tests")
               .get()
               .addOnSuccessListener { res ->
                   Log.d("WAHAHHA" , "${res.toString()}")
                   for (doc in res.documents) {
                       Log.d("WAHAHHA" , "${doc.toObject(MyModel::class.java)}")
                   }
               }
               .addOnFailureListener { e ->
                   Log.d("WAHAHHA" , "${e.message}")
               }
       } catch (e: Exception) {
           Log.d("WAHAHHA" , "ERROR ${e.message}")
       }

    }
}