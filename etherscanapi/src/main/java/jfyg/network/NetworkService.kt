package jfyg.network

import io.reactivex.Single
import jfyg.response.account.AccountBalanceResponse
import jfyg.response.account.AccountBlockResponse
import jfyg.response.account.AccountMultiBalanceResponse
import jfyg.response.account.AccountTransactionResponse
import jfyg.response.stat.StatPriceResponse
import jfyg.response.stat.StatSupplyResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Etherscan request endpoints
 */
interface NetworkService {

    @GET("api")
    fun getStat(@Query("module") module: String?,
                @Query("action") action: String?,
                @Query("apikey") apikey: String?): Single<StatPriceResponse>

    @GET("api")
    fun getStatSupply(@Query("module") module: String?,
                      @Query("action") action: String?,
                      @Query("apikey") apikey: String?): Single<StatSupplyResponse>

    @GET("api")
    fun getAccountBalance(@Query("module") module: String?,
                          @Query("action") action: String?,
                          @Query("address") address: String?,
                          @Query("tag") tag: String?,
                          @Query("apikey") apikey: String?): Single<AccountBalanceResponse>

    @GET("api")
    fun getAccountMultiBalance(@Query("module") module: String?,
                               @Query("action") action: String?,
                               @Query("address") address: String?,
                               @Query("tag") tag: String?,
                               @Query("apikey") apikey: String?): Single<AccountMultiBalanceResponse>

    @GET("api")
    fun getAccountBlock(@Query("module") module: String?,
                        @Query("action") action: String?,
                        @Query("address") address: String?,
                        @Query("blocktype") blocktype: String?,
                        @Query("apikey") apikey: String?): Single<AccountBlockResponse>

    @GET("api")
    fun getAccountTransactions(@Query("module") module: String?,
                               @Query("action") action: String?,
                               @Query("address") address: String?,
                               @Query("startblock") startblock: String?,
                               @Query("endblock") endblock: String?,
                               @Query("sort") sort: String?,
                               @Query("apikey") apikey: String?): Single<AccountTransactionResponse>

}