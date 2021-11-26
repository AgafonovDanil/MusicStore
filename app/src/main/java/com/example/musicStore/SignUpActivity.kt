package com.example.musicStore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignUpActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        email = findViewById(R.id.Email)
        password = findViewById(R.id.Password)
    }
    //кнопка на регистрацию
    fun signInOn(view: android.view.View) {
    val intent = Intent (this, SignInActivity::class.java)
        startActivity(intent)
    }
    //кнопка войти
    fun menuIn(view: android.view.View) {
        if (email.text.isNotEmpty() && password.text.isNotEmpty())
        {
            if (Patterns.EMAIL_ADDRESS.matcher(email.text).matches())
            {
                startActivity(Intent(this@SignUpActivity, MainActivity::class.java))
            }
            else AlertDialog.Builder(this@SignUpActivity).setMessage("Неверная форма Email").show()
        }
        else AlertDialog.Builder(this@SignUpActivity).setMessage("Заполните все поля").show()
    }


}