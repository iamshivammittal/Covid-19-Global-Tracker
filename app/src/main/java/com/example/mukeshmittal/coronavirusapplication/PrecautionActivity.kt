package com.example.mukeshmittal.coronavirusapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_precaution.*

class PrecautionActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precaution)
        recyclerView.layoutManager=
            LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val precautionsList=ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash", "Frequent hand wash is necessary to limit viruses, and this would further reduces chances of getting corona."))
        precautionsList.add(Model(R.drawable.home,"Stay Home", "Staying at home is very important as it would reduce the chain of spread."))
        precautionsList.add(Model(R.drawable.cover,"Use Masks", "Covering your nose and mouth with masks will not allow virus to enter respiratory system."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance", "Social Distancing can break the chain as we are away from people."))
        precautionsList.add(Model(R.drawable.clean,"Clean All Around", "Frequent cleaning of surface we touch will not allow virus to get to our bodies."))

        val precautionsAdapter=PrecautionsAdapter(precautionsList)
        recyclerView.adapter=precautionsAdapter
    }
}
