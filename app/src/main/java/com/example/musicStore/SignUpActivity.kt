package com.example.musicStore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern.compile

class SignUpActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        email = findViewById(R.id.Email)
        password = findViewById(R.id.Password)
    }
    //паттерн
    val paternt =("[a-z0-9]{1,256}" +
            "\\@" +
            "[a-z]{1,10}" +
            "\\." +
            "[a-z]{1,3}")
    fun EmailValid (email:String):Boolean {
        return compile(paternt).matcher(email).matches()
    }
    //кнопка входа
    fun mainOn(view: android.view.View) {
        if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
            if (EmailValid((email.text.toString()))) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else if (password.text.toString().isNotEmpty()) {
                            val alert = AlertDialog.Builder(this)
                            .setTitle("Ошибка")
                            .setMessage("Неверный формат Email")
                                .setPositiveButton("Ок", null)
                                .create()
                                .show()
            }
        }
        if(password.text.toString().isEmpty() || email.text.toString().isEmpty())
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("Ок", null)
                .create()
                .show()
        }
    }
    //кнопка регистрации
    fun signInOn(view: android.view.View) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}