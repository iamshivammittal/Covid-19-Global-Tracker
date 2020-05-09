package com.example.mukeshmittal.coronavirusapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val symptomsList=ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough", "If its not getting better after few weeks, its time to visit your doctor."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache", "Headaches are most common nowadays,take proper sleep and visit doctor if it persists."))
        symptomsList.add(Model(R.drawable.fever,"Fever", "Fever is the most common symptom.Use paracetamol and visit your doctor."))
        symptomsList.add(Model(R.drawable.fatigue,"Fatigue", "Proper rest is advised and if it persists visit your doctor."))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat", "Sore throat is seen as common in Covid-19 patients,you should visit your doctor immediately."))
        val symptomsAdapter=SymptomsAdapter(symptomsList)
        recyclerView.adapter=symptomsAdapter
    }
}
