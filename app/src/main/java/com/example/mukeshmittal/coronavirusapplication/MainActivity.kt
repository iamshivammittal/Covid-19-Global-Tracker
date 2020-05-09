package com.example.mukeshmittal.coronavirusapplication
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          recyclerView.layoutManager=LinearLayoutManager(this, LinearLayout.HORIZONTAL,false)
        val symptomsList=ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough", "If its not getting better after few weeks, its time to visit your doctor."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache", "Headaches are most common nowadays,take proper sleep and visit doctor if it persists."))
        symptomsList.add(Model(R.drawable.fever,"Fever", "Fever is the most common symptom.Use paracetamol and visit your doctor."))
        symptomsList.add(Model(R.drawable.fatigue,"Fatigue", "Proper rest is advised and if it persists visit your doctor."))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat", "Sore throat is seen as common in Covid-19 patients,you should visit your doctor immediately."))

        val symptomsAdapter=SymptomsAdapter(symptomsList)
        recyclerView.adapter=symptomsAdapter

        recyclerViewPrecautions.layoutManager=LinearLayoutManager(this, LinearLayout.HORIZONTAL,false)
        val precautionsList=ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash", "Frequent hand wash is necessary to limit viruses, and this would further reduces chances of getting corona."))
        precautionsList.add(Model(R.drawable.home,"Stay Home", "Staying at home is very important as it would reduce the chain of spread."))
        precautionsList.add(Model(R.drawable.cover,"Use Masks", "Covering your nose and mouth with masks will not allow virus to enter respiratory system."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance", "Social Distancing can break the chain as we are away from people"))
        precautionsList.add(Model(R.drawable.clean,"Clean All Around", "Frequent cleaning of surface we touch will not allow virus to get to our bodies."))


        val precautionsAdapter=PrecautionsAdapter(precautionsList)
        recyclerViewPrecautions.adapter=precautionsAdapter

        txtViewSymptoms.setOnClickListener {
            val intent= Intent(this@MainActivity,SymptomsActivity::class.java)
            startActivity(intent)
        }

      btnKnowMore.setOnClickListener {
           val intent= Intent(this@MainActivity,KnowMoreActivity::class.java)
           startActivity(intent)
       }

        txtViewPrecautions.setOnClickListener {
            val intent= Intent(this@MainActivity,PrecautionActivity::class.java)
            startActivity(intent)
        }

        getGlobalData()
    }

    fun getGlobalData(){
        val url:String="https://corona.lmao.ninja/v2/all"
        val stringRequest:StringRequest= StringRequest(Request.Method.GET,url,
            Response.Listener<String> {
             var jsonObject=JSONObject(it.toString())

                confirmedTv.text=jsonObject.getString("cases")
                recoveredTv.text=jsonObject.getString("recovered")
                deceasedTv.text=jsonObject.getString("deaths")
            },
            Response.ErrorListener {
                Toast.makeText(this@MainActivity,"Something went wrong",Toast.LENGTH_LONG).show()
                confirmedTv.text="-"
                recoveredTv.text="-"
                deceasedTv.text="-"
            }
        )
       val requestQueue=Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }

}
