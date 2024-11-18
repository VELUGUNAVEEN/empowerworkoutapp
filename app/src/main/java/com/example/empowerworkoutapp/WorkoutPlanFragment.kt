package com.example.empowerworkoutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.Calendar


class WorkoutPlanFragment : Fragment() {

    private val workoutData = mapOf(
        "Monday" to Pair("Chest + Triceps", R.drawable.chest),
        "Tuesday" to Pair("Back + Biceps + Abs", R.drawable.back),
        "Wednesday" to Pair("Shoulder + Legs", R.drawable.shoulder),
        "Thursday" to Pair("Chest + Triceps", R.drawable.chest),
        "Friday" to Pair("Back + Biceps + Abs", R.drawable.back),
        "Saturday" to Pair("Shoulder + Legs", R.drawable.shoulder),
        "Sunday" to Pair("Rest", R.drawable.rest)
    )

    private val vegDietData = mapOf(
        "Monday" to Pair("Vegetable Salad with Quinoa", R.drawable.veg_monday),
        "Tuesday" to Pair("Grilled Paneer with Brown Rice", R.drawable.veg_tuesday),
        "Wednesday" to Pair("Vegetable Stir-fry with Tofu", R.drawable.veg_wednesday),
        "Thursday" to Pair("Chickpea Salad", R.drawable.veg_thursday),
        "Friday" to Pair("Lentil Soup with Bread", R.drawable.veg_friday),
        "Saturday" to Pair("Spinach and Cheese Wrap", R.drawable.veg_saturday),
        "Sunday" to Pair("Fruit Smoothie Bowl", R.drawable.veg_sunday)
    )

    private val nonVegDietData = mapOf(
        "Monday" to Pair("Grilled Chicken with Vegetables", R.drawable.nonveg_monday),
        "Tuesday" to Pair("Fish Curry with Rice", R.drawable.nonveg_tuesday),
        "Wednesday" to Pair("Egg Salad Sandwich", R.drawable.nonveg_wednesday),
        "Thursday" to Pair("Turkey Wrap with Veggies", R.drawable.nonveg_thursday),
        "Friday" to Pair("Chicken Soup with Bread", R.drawable.nonveg_friday),
        "Saturday" to Pair("Shrimp Stir-fry with Rice", R.drawable.nonveg_saturday),
        "Sunday" to Pair("Grilled Salmon with Salad", R.drawable.nonveg_sunday)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_workout_plan, container, false)

        val tvWorkoutTitle = view.findViewById<TextView>(R.id.tvWorkoutTitle)
        val ivWorkoutImage = view.findViewById<ImageView>(R.id.ivWorkoutImage)
        val tvVegDietTitle = view.findViewById<TextView>(R.id.tvVegDietTitle)
        val ivVegDietImage = view.findViewById<ImageView>(R.id.ivVegDietImage)
        val tvNonVegDietTitle = view.findViewById<TextView>(R.id.tvNonVegDietTitle)
        val ivNonVegDietImage = view.findViewById<ImageView>(R.id.ivNonVegDietImage)

        val currentDay = getCurrentDay()

        // Set Workout Data
        tvWorkoutTitle.text = workoutData[currentDay]?.first
        ivWorkoutImage.setImageResource(workoutData[currentDay]?.second ?: R.drawable.shoulder)

        // Set Veg Diet Data
        tvVegDietTitle.text = vegDietData[currentDay]?.first
        ivVegDietImage.setImageResource(vegDietData[currentDay]?.second ?: R.drawable.veg_monday)

        // Set Non-Veg Diet Data
        tvNonVegDietTitle.text = nonVegDietData[currentDay]?.first
        ivNonVegDietImage.setImageResource(nonVegDietData[currentDay]?.second ?: R.drawable.nonveg_friday)

        return view
    }

    private fun getCurrentDay(): String {
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> "Monday"
            Calendar.TUESDAY -> "Tuesday"
            Calendar.WEDNESDAY -> "Wednesday"
            Calendar.THURSDAY -> "Thursday"
            Calendar.FRIDAY -> "Friday"
            Calendar.SATURDAY -> "Saturday"
            Calendar.SUNDAY -> "Sunday"
            else -> "Monday" // Fallback
        }
    }
}
