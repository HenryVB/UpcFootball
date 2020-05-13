package com.upc.football.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.upc.football.R
import com.upc.football.models.Team

class TeamAdapter(private val teams: List<Team>, private val context: Context, private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val ivLogo = view.findViewById(R.id.ivLogo) as ImageView
        val tvName = view.findViewById(R.id.tvName) as TextView
        val cvTeam = view.findViewById(R.id.cvTeam) as CardView
    }

    interface OnItemClickListener {
        fun onItemClicked(team: Team)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.prototype_team,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamAdapter.ViewHolder, position: Int) {

        val team = teams[position]

        holder.tvName.text = team.name

        val picBuilder = Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(team.logo)
            .placeholder((R.drawable.ic_launcher_background))
            .error(R.drawable.ic_launcher_background)
            .into(holder.ivLogo);

        holder.cvTeam.setOnClickListener {
            itemClickListener.onItemClicked(team)
        }
    }

}