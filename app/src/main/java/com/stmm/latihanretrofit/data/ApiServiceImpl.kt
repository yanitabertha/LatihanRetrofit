package com.stmm.latihanretrofit.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceImpl {

    //companion object biar aksesnya bisa static tanpa mengganggu yg lain
    companion object {
        private val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/" //nanti end pointnya ada di interface
        //yang isinya ada GET PUSH DELETE. jadi seluruh class ada disini gtu
        //URL untuk ambil API

        //digunakan untuk rest clientnya
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }

    }
}