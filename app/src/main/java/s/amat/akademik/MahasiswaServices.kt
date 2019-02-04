package s.amat.akademik


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.FieldMap




interface MahasiswaServices {

    @GET("mahasiswa")
    fun getData(@Query("nim") nim:String):Call<MahasiswaResponse>

    @GET("category")
    fun getData():Call<CategoryResponse>


    @FormUrlEncoded
    @POST("mahasiswa")
    fun postData(@Field ("nim") nim: String, @Field ("nama") nama: String,@Field ("id_jurusan") id_jurusan: Int,@Field ("alamat") alamat: String  ): Call<MahasiswaResponse>


    @FormUrlEncoded
    @POST("mahasiswa")
    fun postData2(@Field ("nim") nim: String, @Field ("nama") nama: String): Call<MahasiswaResponse>
}