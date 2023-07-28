package com.bangkit.rakaminsubmission

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getNews(
        @Header("apiKey") apiKey : String,
        @Query("q") q : String,
        @Query("pageSize") pageSize : Int,
    ) : Call<Response>
}