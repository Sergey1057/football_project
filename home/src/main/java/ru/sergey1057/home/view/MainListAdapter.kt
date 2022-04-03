package ru.sergey1057.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.sergey1057.home.R
import ru.sergey1057.home.models.TeamModel

class MainListAdapter(
) : RecyclerView.Adapter<MainListAdapter.TeamViewHolder>() {

    var specificationsList: MutableList<TeamModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder =
        TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.main_cell_layout, parent, false)
        )

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(specificationsList[position])
    }

    override fun getItemCount(): Int =
        specificationsList.size

    class TeamViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val teamNumber: TextView = itemView.findViewById(R.id.team_number)
        private val teamName: TextView = itemView.findViewById(R.id.team_name)
        private val teamMatches: TextView = itemView.findViewById(R.id.team_matches)
        private val teamPoints: TextView = itemView.findViewById(R.id.team_points)

        fun bind(teamModel: TeamModel) {
            teamNumber.text = teamModel.teamNumber
            teamName.text = teamModel.teamName
            teamMatches.text = teamModel.teamMatches
            teamPoints.text = teamModel.teamPoints
        }
    }
}