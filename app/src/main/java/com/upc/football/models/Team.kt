package com.upc.football.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Team (
    @SerializedName("team_id")
    val team_id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("founded")
    val founded: Int,
    @SerializedName("venue_name")
    val venue_name: String,
    @SerializedName("venue_surface")
    val venue_surface: String,
    @SerializedName("venue_address")
    val venue_address: String,
    @SerializedName("venue_city")
    val venue_city: String,
    @SerializedName("venue_capacity")
    val venue_capacity: Int
) : Serializable {

}