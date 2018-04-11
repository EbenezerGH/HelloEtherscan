package jfyg.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers

/**
 * Client used to create the network call
 */
class RestClient {

    private var baseUrl: String = "http://api.etherscan.io/"
    private var networkService: NetworkService

    init {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        networkService = retrofit.create(NetworkService::class.java)
    }

    fun getQuery(): NetworkService {
        return networkService
    }

}