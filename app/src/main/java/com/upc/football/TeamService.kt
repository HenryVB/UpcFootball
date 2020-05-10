package com.upc.football

import com.upc.football.models.ApiResponseDetails
import com.upc.football.models.ApiResponseHeader
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TeamService {
    //@Headers({"Accept: application/json"})
    //@Headers("x-rapidapi-host:api-football-v1.p.rapidapi.com")

    @GET("1341")
    fun getTeams(@Header("x-rapidapi-host")host: String, @Header("x-rapidapi-key")apiKey: String): Call<ApiResponseHeader>
}