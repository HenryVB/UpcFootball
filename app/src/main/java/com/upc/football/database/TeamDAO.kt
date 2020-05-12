package com.upc.football.database

import androidx.room.*
import com.upc.football.models.Team

@Dao
interface TeamDAO {

    @Insert
    fun insertTeam(vararg team: Team)

    @Query("SELECT * FROM teams ")
    fun getAllTeams(): List<Team>

    @Delete
    fun deleteTeams(vararg team: Team)

    @Update
    fun updateTeams(vararg team: Team)
}