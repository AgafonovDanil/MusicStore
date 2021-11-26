package com.example.musicStore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignInActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var phone: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var trypassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        name = findViewById(R.id.nameUser)
        phone = findViewById(R.id.phoneUser)
        email = findViewById(R.id.emailUser)
        password = findViewById(R.id.passwordUser)
        trypassword = findViewById(R.id.passwordTryUser)


    }
    //кнопка вернуться
    fun backUp(view: android.view.View) {
        val intent = Intent (this, SignUpActivity::class.java)
        startActivity(intent)
    }
    //кнопка зарегистрироваться
    fun inSignUp(view: android.view.View) {

        if (phone.text.isNotEmpty() && name.text.isNotEmpty() && email.text.isNotEmpty() && trypassword.text.isNotEmpty() && password.text.isNotEmpty())
        {
            if (Patterns.EMAIL_ADDRESS.matcher(email.text).matches())
            {
                if (password.text.toString() != trypassword.text.toString())
                {
                    AlertDialog.Builder(this@SignInActivity).setMessage("Пароли не совпадают").show()
                }
                else startActivity(Intent(this@SignInActivity, MainActivity::class.java))
            }
            else AlertDialog.Builder(this@SignInActivity).setMessage("Неверная форма Email").show()
        }
        else AlertDialog.Builder(this@SignInActivity).setMessage("Заполните все поля").show()
    }

}