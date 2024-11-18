package com.example.empowerworkoutapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empowerworkoutapp.R
import com.example.empowerworkoutapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Sample data for the week
        val scheduleList = listOf(
            DaySchedule("Monday", "Chest + Triceps", R.drawable.chest),
            DaySchedule("Tuesday", "Back + Biceps + Abs", R.drawable.back),
            DaySchedule("Wednesday", "Shoulder + Legs", R.drawable.shoulder),
            DaySchedule("Thursday", "Chest + Triceps", R.drawable.chest),
            DaySchedule("Friday", "Back + Biceps + Abs", R.drawable.back),
            DaySchedule("Saturday", "Shoulder + Legs", R.drawable.shoulder),
            DaySchedule("Sunday", "Rest", R.drawable.rest)
        )

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = ScheduleAdapter(scheduleList)

        return binding.root
    }
}
