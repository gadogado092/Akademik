package s.amat.akademik

import android.app.Activity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.kata_adapter.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class DetailActivity : Activity() {

    private lateinit var categoryModel: CategoryModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle = intent.getBundleExtra("myBundle")


        if (bundle!=null){
            categoryModel = bundle.getParcelable("selected") as CategoryModel

            val categoryServices = DataRepository.create()
            categoryServices.getItem(categoryModel.pk_i_id).enqueue(object : Callback<ItemModel> {
                override fun onResponse(call: Call<ItemModel>, response: Response<ItemModel>) {
                    if (response.isSuccessful) {
                        textView.text=response.body()?.s_title
                    }
                }

                override fun onFailure(call: Call<ItemModel>, t: Throwable) {
                    Log.d("Kampret","errornya = ${t.message}")
                }

            })

        }
    }
}
