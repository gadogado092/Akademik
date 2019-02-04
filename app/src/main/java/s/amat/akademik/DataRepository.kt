package s.amat.akademik

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {

    /*fun create(): MahasiswaServices{

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.amiklan.com/apps/v0.1/category")
            .build()
        return retrofit.create(MahasiswaServices::class.java)
    }*/

    fun create(): CategoryServices{

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.amiklan.com/apps/v1/")
            .build()
        return retrofit.create(CategoryServices::class.java)
    }
}