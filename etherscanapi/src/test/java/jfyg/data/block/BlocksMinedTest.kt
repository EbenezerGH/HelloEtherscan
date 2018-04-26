package jfyg.data.block

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import jfyg.network.response.block.BlockResponse
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class BlocksMinedTest {
    lateinit var gson: Gson

    private val minedBlocks = """
    {
        "status": "1",
        "message": "OK",
        "result": {
        "blockNumber": "2165403",
        "timeStamp": "1472533979",
        "blockMiner": "0x13a06d3dfe21e0db5c016c03ea7d2509f7f8d1e3",
        "blockReward": "5314181600000000000",
        "uncles": [
        {
            "miner": "0xbcdfc35b86bedf72f0cda046a3c16829a2ef41d1",
            "unclePosition": "0",
            "blockreward": "3750000000000000000"
        },
        {
            "miner": "0x0d0c9855c722ff0c78f21e43aa275a5b8ea60dce",
            "unclePosition": "1",
            "blockreward": "3750000000000000000"
        }
        ],
        "uncleInclusionReward": "312500000000000000"
    }
    }"""

    @Before
    fun setUp() {
        val gb = GsonBuilder()
        gson = gb.create()
    }

    @Test
    fun getBlocksMined() {
        val response = gson.fromJson(minedBlocks, BlockResponse::class.java)
        assertEquals("0x13a06d3dfe21e0db5c016c03ea7d2509f7f8d1e3", response.result.blockMiner)
        assertEquals("2165403", response.result.blockNumber)
        assertEquals("5314181600000000000", response.result.blockReward)
        assertEquals("3750000000000000000", response.result.uncles?.get(0)?.blockReward)
    }

}