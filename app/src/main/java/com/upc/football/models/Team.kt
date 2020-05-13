package com.upc.football.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "teams"
)
data class Team (
    @PrimaryKey
    @SerializedName("team_id")
    val team_id : Int =0,
    @SerializedName("name")
    val name : String,
    @SerializedName("code")
    val code : String?,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("is_national")
    val is_national: Boolean,
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