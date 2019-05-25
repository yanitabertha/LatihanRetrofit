package com.stmm.latihanretrofit.data

import com.stmm.latihanretrofit.data.model.DataLiga
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search_all_leagues.php")
    fun getDataLiga(
        @Query("c") liga: String,
        @Query("s") sport: String)
            : Call<DataLiga>

    //DIAMBIL DARI LINK https://www.thesportsdb.com/api/v1/json/1/search_all_leagues.php?c=England&s=Soccer
    //ada query C dan S
}