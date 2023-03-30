package com.example.myuca20
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONException
import android.util.Log

class MainActivity : AppCompatActivity() {

    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.btnVer)
        button.setOnClickListener {
            text = findViewById(R.id.txtDatos)
            ver()
        }

    }

    fun ver() {

        val queue = Volley.newRequestQueue(this)
        val url = "http://10.0.2.2:80/myuca/verEdad60.php"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    val datosArray = response.getJSONArray("data")
                    text.text=datosArray.toString()
                } catch (e: JSONException) {
                    Log.e("JSON", e.toString())

                }
            },
            { error ->
                Log.e("JSON", error.toString())
            }
        )
        queue.add(jsonObjectRequest)
    }
}