package jfyg.data

import com.google.gson.annotations.SerializedName

data class TxsInternal(val blockNumber: String,

                       val timeStamp: String,

                       val hash: String,

                       @SerializedName("from")
                       val transactionFrom: String,

                       @SerializedName("to")
                       val transactionTo: String,

                       val value: String,

                       val contactAddress: String,

                       val input: String,

                       val type: String,

                       val gas: String,

                       val gasUsed: String,

                       val traceId: String,

                       val isError: String,

                       val errCode: String)