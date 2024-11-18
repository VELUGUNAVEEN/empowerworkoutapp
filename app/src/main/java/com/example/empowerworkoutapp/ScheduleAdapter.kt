package com.example.empowerworkoutapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScheduleAdapter(private val scheduleList: List<DaySchedule>) :
    RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    class ScheduleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayTextView: TextView = view.findViewById(R.id.dayTextView)
        val workoutTextView: TextView = view.findViewById(R.id.workoutTextView)
        val workoutImageView: ImageView = view.findViewById(R.id.workoutImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = scheduleList[position]
        holder.dayTextView.text = schedule.day
        holder.workoutTextView.text = schedule.workout
        holder.workoutImageView.setImageResource(schedule.imageResId)
    }

    override fun getItemCount() = scheduleList.size
}
