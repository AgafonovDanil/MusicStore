package com.example.musicStore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun signInOn(view: android.view.View) {
    val intent = Intent (this, SignInActivity::class.java)
        startActivity(intent)
    }

}