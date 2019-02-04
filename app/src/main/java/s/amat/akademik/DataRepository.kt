package s.amat.akademik

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {

    fun create(): MahasiswaServices{

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.1.68/apimhs/index.php/")
            .build()
        return retrofit.create(MahasiswaServices::class.java)
    }
}