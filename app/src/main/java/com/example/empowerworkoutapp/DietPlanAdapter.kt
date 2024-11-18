package com.example.empowerworkoutapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DietPlanAdapter(private var dietPlanList: List<DietPlan>) :
    RecyclerView.Adapter<DietPlanAdapter.DietPlanViewHolder>() {

    class DietPlanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayTextView: TextView = view.findViewById(R.id.dayTextView)
        val mealTextView: TextView = view.findViewById(R.id.mealTextView)
        val mealImageView: ImageView = view.findViewById(R.id.mealImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietPlanViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_diet_plan, parent, false)
        return DietPlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: DietPlanViewHolder, position: Int) {
        val dietPlan = dietPlanList[position]
        holder.dayTextView.text = dietPlan.day
        holder.mealTextView.text = dietPlan.meal
        holder.mealImageView.setImageResource(dietPlan.imageResId)
    }

    override fun getItemCount() = dietPlanList.size

    // Update data and notify RecyclerView
    fun updateData(newDietPlanList: List<DietPlan>) {
        dietPlanList = newDietPlanList
        notifyDataSetChanged()
    }
}
