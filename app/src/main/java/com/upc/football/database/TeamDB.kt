package com.upc.football.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.upc.football.models.Team

@Database(entities = [Team::class], version = 1)
abstract class TeamDB : RoomDatabase() {
    abstract fun getTeamDAO() : TeamDAO

    companion object {

        private var INSTANCE : TeamDB?= null


        fun getInstance(context: Context) : TeamDB {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, TeamDB::class.java, "team.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as TeamDB
        }




    }

        

}