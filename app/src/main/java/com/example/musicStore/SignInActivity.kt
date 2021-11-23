package com.example.musicStore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun backUp(view: android.view.View) {
        val intent = Intent (this, SignUpActivity::class.java)
        startActivity(intent)
    }

    fun inSignUp(view: android.view.View) {
        val intent = Intent (this, SignUpActivity::class.java)
        startActivity(intent)
    }

}