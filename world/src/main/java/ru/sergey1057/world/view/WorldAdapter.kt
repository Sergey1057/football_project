package ru.sergey1057.world.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.sergey1057.world.R
import ru.sergey1057.world.models.WorldModel

class WorldAdapter(
) : RecyclerView.Adapter<WorldAdapter.TeamViewHolder>() {

    var worldList: MutableList<WorldModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder =
        TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.world_cell, parent, false)
        )

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(worldList[position])
    }

    override fun getItemCount(): Int =
        worldList.size

    class TeamViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val worldPosition: TextView = itemView.findViewById(R.id.world_position)
        private val worldDate: TextView = itemView.findViewById(R.id.world_date)
        private val worldName: TextView = itemView.findViewById(R.id.world_name)

        fun bind(worldModel: WorldModel) {
            worldPosition.text = worldModel.worldPosition
            worldDate.text = worldModel.worldCupDate
            worldName.text = worldModel.chempionName
        }
    }
}
