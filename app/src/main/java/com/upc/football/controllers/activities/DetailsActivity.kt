package com.upc.football.controllers.activities

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.upc.football.R
import com.upc.football.database.TeamDB
import com.upc.football.models.Team

class DetailsActivity : AppCompatActivity() {

    lateinit var ivTeamDetail: ImageView
    lateinit var tvName: TextView
    lateinit var tvID: TextView
    lateinit var tvCode: TextView
    lateinit var tvCountry: TextView
    lateinit var tvFounded: TextView
    lateinit var tvVenueName: TextView
    lateinit var tvVenueSurface: TextView
    lateinit var tvVenueAddress: TextView
    lateinit var tvVenueCity: TextView
    lateinit var tvVenueCapacity: TextView
    lateinit var fabInsert: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_details)
        ivTeamDetail = findViewById(R.id.ivTeamDetail)
        tvName = findViewById(R.id.tvNameDetail)
        tvID = findViewById(R.id.tvTeamID)
        tvCode = findViewById(R.id.tvCode)
        tvCountry = findViewById(R.id.tvCountry)
        tvFounded = findViewById(R.id.tvFounded)
        tvVenueName = findViewById(R.id.tvVenueName)
        tvVenueSurface = findViewById(R.id.tvVenueSurface)
        tvVenueAddress = findViewById(R.id.tvVenueAddress)
        tvVenueCity = findViewById(R.id.tvVenueCity)
        tvVenueCapacity = findViewById(R.id.tvVenueCapacity)
        fabInsert = findViewById(R.id.fab)

        initFields(this)
    }

    private fun initFields(context: Context){

        val teamObject: Team? = intent.getSerializableExtra("Team") as Team?

        val picBuilder = Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(teamObject?.logo)
            .placeholder((R.drawable.ic_launcher_background))
            .error(R.drawable.ic_launcher_background)
            .into(ivTeamDetail);

        tvName.text = teamObject?.name
        tvID.text = teamObject?.team_id.toString()
        tvCode.text = teamObject?.code
        tvCountry.text = teamObject?.country
        tvFounded.text = teamObject?.founded.toString()
        tvVenueName.text = teamObject?.venue_name
        tvVenueSurface.text = teamObject?.venue_surface
        tvVenueAddress.text = teamObject?.venue_address
        tvVenueCity.text = teamObject?.venue_city
        tvVenueCapacity.text = teamObject?.venue_capacity.toString()

        fabInsert.setOnClickListener {
            saveTeam(teamObject)
            finish()
        }
    }

    private fun saveTeam(teamObject: Team?){
        //TODO Registro en base de datos
        if (teamObject != null) {
            TeamDB.getInstance(this).getTeamDAO().insertTeam(teamObject)
        }
    }
}