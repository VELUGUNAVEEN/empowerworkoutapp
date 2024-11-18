package com.example.empowerworkoutapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DietMealPlanFragment : Fragment() {

    private val vegDietPlan = listOf(
        DietPlan("Monday", "Vegetable Salad with Quinoa", R.drawable.veg_monday),
        DietPlan("Tuesday", "Grilled Paneer with Brown Rice", R.drawable.veg_tuesday),
        DietPlan("Wednesday", "Vegetable Stir-fry with Tofu", R.drawable.veg_wednesday),
        DietPlan("Thursday", "Chickpea Salad", R.drawable.veg_thursday),
        DietPlan("Friday", "Lentil Soup with Bread", R.drawable.veg_friday),
        DietPlan("Saturday", "Spinach and Cheese Wrap", R.drawable.veg_saturday),
        DietPlan("Sunday", "Fruit Smoothie Bowl", R.drawable.veg_sunday)
    )

    private val nonVegDietPlan = listOf(
        DietPlan("Monday", "Grilled Chicken with Vegetables", R.drawable.nonveg_monday),
        DietPlan("Tuesday", "Fish Curry with Rice", R.drawable.nonveg_tuesday),
        DietPlan("Wednesday", "Egg Salad Sandwich", R.drawable.nonveg_wednesday),
        DietPlan("Thursday", "Turkey Wrap with Veggies", R.drawable.nonveg_thursday),
        DietPlan("Friday", "Chicken Soup with Bread", R.drawable.nonveg_friday),
        DietPlan("Saturday", "Shrimp Stir-fry with Rice", R.drawable.nonveg_saturday),
        DietPlan("Sunday", "Grilled Salmon with Salad", R.drawable.nonveg_sunday)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_diet_meal_plan_fragment, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.dietPlanRecyclerView)
        val vegButton = view.findViewById<Button>(R.id.vegButton)
        val nonVegButton = view.findViewById<Button>(R.id.nonVegButton)

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = DietPlanAdapter(vegDietPlan) // Default to vegDietPlan
        recyclerView.adapter = adapter

        // Button click listeners
        vegButton.setOnClickListener {
            adapter.updateData(vegDietPlan) // Update adapter with vegDietPlan
        }

        nonVegButton.setOnClickListener {
            adapter.updateData(nonVegDietPlan) // Update adapter with nonVegDietPlan
        }

        return view
    }
}
