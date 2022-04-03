package ru.sergey1057.scorers.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.sergey1057.scorers.R
import ru.sergey1057.scorers.models.ScorerModel


class ScorersAdapter(
) : RecyclerView.Adapter<ScorersAdapter.TeamViewHolder>() {

    var scorersList: MutableList<ScorerModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder =
        TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.scorer_cell, parent, false)
        )

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(scorersList[position])
    }

    override fun getItemCount(): Int =
        scorersList.size

    class TeamViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val scorerPosition: TextView = itemView.findViewById(R.id.scorer_position)
        private val scorerName: TextView = itemView.findViewById(R.id.scorer_name)
        private val scorerTeam: TextView = itemView.findViewById(R.id.scorer_team)
        private val scorerGoals: TextView = itemView.findViewById(R.id.scorer_goals)

        fun bind(scorerModel: ScorerModel) {
            scorerPosition.text = scorerModel.scorerPosition
            scorerName.text = scorerModel.scorerName
            scorerTeam.text = scorerModel.scorerTeam
            scorerGoals.text = scorerModel.scorerGoals
        }
    }
}
