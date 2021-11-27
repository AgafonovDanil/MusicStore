package com.example.musicStore

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
//import com.example.musicStore.net.ApiRet
//import com.example.musicStore.net.MyRetrofit
import retrofit2.Call
//import retrofit2.Class
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var sharedPreferences: SharedPreferences
    lateinit var checkBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val root = LayoutInflater.from(this).inflate(R.layout.activity_sign_up, null, false)
        email = findViewById(R.id.Email)
        password = findViewById(R.id.Password)
        checkBox = findViewById(R.id.cb_save)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
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
                val log = MyRetrofit().GetRetrofit()
                val getApi = log.create(RetApi::class.java)
                val hashMap: HashMap<String, String> = HashMap<String, String>()
                hashMap.put("email", email.text.toString())
                hashMap.put("password", password.text.toString())
                val log_call: retrofit2.Call<login> = getApi.gerAuth(hashMap)
                log_call.enqueue(object : retrofit2.Callback<login> {
                    override fun onResponse(call: Call<login>, response: Response<login>) {
                        if (response.isSuccessful) {
                            val editor = sharedPreferences.edit()
                            editor.putString(
                                "email",
                                response.body()?.email
                            )//поле не пустое использ библ glide
                            editor.putString("avatar", response.body()?.avatar)
                            editor.putString("name", response.body()?.nickName)
                            editor.putString("id", response.body()?.id)
                            editor.putBoolean("save", true)
                            editor.apply()
                            //check
                            startActivity(Intent(this@SignUpActivity, MenuActivity::class.java))
                        }
                    }
                })


            }
            else AlertDialog.Builder(this@SignUpActivity).setMessage("Неверная форма Email").show()
        }
        else AlertDialog.Builder(this@SignUpActivity).setMessage("Заполните все поля").show()
    }


}