package s.amat.akademik

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import org.json.JSONArray




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val mahasiswaServices = DataRepository.create()
        mahasiswaServices.getData("").enqueue(object : Callback<MahasiswaResponse>{
            override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
                Log.d("tag","errornya = ${t.message}")
            }

            override fun onResponse(call: Call<MahasiswaResponse>, response: Response<MahasiswaResponse>) {
                    if (response.isSuccessful) {
                        val a = response.body()?.mahasiswa

                        Log.d("tag", "TES "+a.toString())
                    }
                }

        })*/

        val mahasiswaServices = DataRepository.create()

        mahasiswaServices.postData("e1e1aaaadasammm","saya",2,"alamat saya").enqueue(object : Callback<MahasiswaResponse>{
            override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
                Log.d("kampret","errornya = ${t.message}")
            }

            override fun onResponse(call: Call<MahasiswaResponse>, response: Response<MahasiswaResponse>) {
                if (response.isSuccessful) {
                    val a = response.body()

                    Log.d("kampret", "TES "+a.toString())
                }
            }

        })
    }
}
