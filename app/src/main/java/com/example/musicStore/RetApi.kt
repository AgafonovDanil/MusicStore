package com.example.musicStore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.http.*
import retrofit2.Call

interface RetApi{
    @POST("auth/login")
    fun login(@Body hashMap: HashMap<String, String>): Call<Login>

    @POST("auth/register")
    fun registration(@Body hashMap: HashMap<String, String>): Call<Void>
}