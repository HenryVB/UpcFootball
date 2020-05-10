package com.upc.football.models

import com.google.gson.annotations.SerializedName

data class ApiResponseHeader (
    @SerializedName("api")
    var api: ApiResponseDetails
) {
}