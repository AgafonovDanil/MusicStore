package com.example.musicStore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class SignInActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var phone: EditText
    lateinit var password: EditText
    lateinit var trypassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        name = findViewById(R.id.nameUser)
        email = findViewById(R.id.emailUser)
        phone = findViewById(R.id.phoneUser)
        password = findViewById(R.id.passwordUser)
        trypassword = findViewById(R.id.passwordTryUser)
    }

    //паттерн
    val paternt = ("[a-z0-9]{1,256}" +
            "\\@" +
            "[a-z]{1,10}" +
            "\\." +
            "[a-z]{1,3}")

    fun EmailValid(email: String): Boolean {
        return Pattern.compile(paternt).matcher(email).matches()
    }

    //кнопка вернуться в окно авторизации
    fun backUp(view: android.view.View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    //кнопка зарегистрироваться
    fun inSignUp(view: android.view.View) {
        if (name.text.toString().isNotEmpty() && email.text.toString()
                .isNotEmpty() && phone.text.toString().isNotEmpty() && password.text.toString()
                .isNotEmpty() && trypassword.text.toString().isNotEmpty() && password.text.toString() == trypassword.text.toString()) {
            if (EmailValid((email.text.toString()))) {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            } else if (name.text.toString().isNotEmpty() && phone.text.toString().isNotEmpty() && password.text.toString()
                    .isNotEmpty() && trypassword.text.toString().isNotEmpty()) {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Неверный формат Email")
                    .setPositiveButton("Ок", null)
                    .create()
                    .show()
            }

            else if(password.text.toString() != trypassword.text.toString())
            {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Пароли не совпадают")
                    .setPositiveButton("Ок", null)
                    .create()
                    .show()
            }
        }
        if(name.text.toString().isEmpty() || email.text.toString()
                .isEmpty() || phone.text.toString().isEmpty() || password.text.toString()
                .isEmpty() || trypassword.text.toString().isEmpty())
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("Ок", null)
                .create()
                .show()
        }

    }

}