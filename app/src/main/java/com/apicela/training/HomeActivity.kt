package com.apicela.training

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.apicela.training.utils.DataManager
import com.google.gson.Gson
import java.io.Serializable

class HomeActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var listView: ListView
    private lateinit var exercisesButton: ImageButton
    private lateinit var calendarButton: ImageButton
    private lateinit var dataManager : DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        DataManager.initialize(this)
        exercisesButton = findViewById(R.id.exercise_button)
        calendarButton = findViewById(R.id.calendar_button)
        val listItems = DataManager.loadExerciseItems() as Serializable
        exercisesButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, ExerciseActivity::class.java)
            intent.putExtra("exercise_list", listItems)
            startActivity(intent)
        }

        calendarButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, CalendarActivity::class.java)
            startActivity(intent)
        }
    }


}