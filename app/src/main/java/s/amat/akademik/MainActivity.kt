package s.amat.akademik

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import org.json.JSONArray




class MainActivity : AppCompatActivity() {

    private lateinit var rvKata: RecyclerView
    private lateinit var adapter: CategoryAdapter
    private var listKata : MutableList<CategoryModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter= CategoryAdapter(applicationContext,listKata){
            val intent = Intent(applicationContext, DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable("selected", it)
            intent.putExtra("myBundle", bundle)
            startActivity(intent)


        }

        rvKata= findViewById(R.id.list)
        rvKata.layoutManager = LinearLayoutManager(applicationContext)
        rvKata.setHasFixedSize(true)
        rvKata.adapter=adapter

        /* val mahasiswaServices = DataRepository.create()

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

         })*/

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



        val categoryServices = DataRepository.create()
        categoryServices.getData().enqueue(object :Callback<List<CategoryModel>>{
            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {
                if (response.isSuccessful) {
                    listKata.clear()
                    val data = response.body()
                    //Log.d("tag", "responsennya ${data?.size}")

                    data?.let { listKata.addAll(it) }
                    adapter.notifyDataSetChanged()

                    data?.map {

                        //Log.d("tag", "datanya ${it.pk_i_id}")
                    }
                }
            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                Log.d("tag","errornya = ${t.message}")
            }

        })




    }
}
