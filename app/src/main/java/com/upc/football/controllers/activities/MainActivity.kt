package com.upc.football.controllers.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upc.football.R
import com.upc.football.network.TeamService
import com.upc.football.adapters.TeamAdapter
import com.upc.football.controllers.fragments.SaveFragment
import com.upc.football.controllers.fragments.TeamFragment
import com.upc.football.models.ApiResponseHeader
import com.upc.football.models.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        Log.d("a","1")
        navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        Log.d("a","2")
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        Log.d("a","3")
        Log.d("a","menuhome:"+ R.id.menu_home)
        navigateTo(navView.menu.findItem(R.id.menu_home))
    }

    private fun getFragmentFor(item: MenuItem): Fragment {
        Log.d("a","4")
        Log.d("a","itemId: " + item.itemId)
        return when(item.itemId) {
            R.id.menu_home -> TeamFragment()
            R.id.menu_detail -> SaveFragment()
            else -> TeamFragment()
        }
    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        Log.d("a","5")
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment, getFragmentFor(item))
            .commit() > 0
        Log.d("a","6")
    }
    //lateinit var teamRecyclerView: RecyclerView
    //val teams: List<Team> = ArrayList()

    //override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //teamRecyclerView = findViewById(R.id.rvTeams)
        //loadTeams(this)


    /*private fun loadTeams(context: Context){

        Log.d("Init load", "Init")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v2/teams/league/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        //DECLARAMOS NUESTRO OBJETO TeamService
        val teamService: TeamService
        teamService = retrofit.create(TeamService::class.java)
        val request = teamService.getTeams("api-football-v1.p.rapidapi.com","d229813befmsh4c1646ad132a0b5p1313fcjsn9afecaefc97e")

        request.enqueue(object : Callback<ApiResponseHeader> {

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                Log.d("Activity Fail", "Error: "+t.toString())
            }

            override fun onResponse(call: Call<ApiResponseHeader>, responseDetails: Response<ApiResponseHeader>) {

                if (responseDetails.isSuccessful) {
                    Log.d("MSG", responseDetails.message())
                    Log.d("Error Body", responseDetails.errorBody().toString())
                    Log.d("Activity Success", responseDetails.raw().toString())
                    Log.d("Activity Success", responseDetails.body().toString())
                    Log.d("Activity Success 1", responseDetails.body()?.api?.results.toString())
                    Log.d("Activity Success 2", responseDetails.body()?.api?.teams?.size.toString())


                    val teams: List<Team> = responseDetails.body()!!.api.teams ?: ArrayList()
                    teamRecyclerView.layoutManager = LinearLayoutManager(context)
                    teamRecyclerView.adapter = TeamAdapter(teams,context)
                }

                else{
                    Log.d("Activity Fail", "Error: "+responseDetails.code())
                }
            }

        })

    }*/
}
