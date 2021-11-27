package com.example.musicStore

data class Login(val token: Int){
    companion object Login{
        var userToken: Int? = null
    }
}