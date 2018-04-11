package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import jfyg.account.Account
import jfyg.stat.Stat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //************************************************  Used To Test Library
        val stat = Stat()
        val account = Account()

        fab.setOnClickListener {

            //stat
            Log.d(TAG, "The Stat Status is ${stat.getNetworkStatus()}")
            Log.d(TAG, "The Stat Message is ${stat.getNetworkMessage()}")
            Log.d(TAG, "The current price of Ether in Btc:  ${stat.getLastPriceInBtc()}")
            Log.d(TAG, "Timestamp price in Btc:  ${stat.getBtcTimestamp()}")
            Log.d(TAG, "Timestamp price in Ether:  ${stat.getEthTimestamp()}")
            Log.d(TAG, "The current price of Ether in Usd:  ${stat.getLastPriceInUsd()}")
            Log.d(TAG, "The total supply of Ether:  ${stat.getTotalSupply()}")
            Log.d(TAG, "The total supply of Ether in Wei:  ${stat.getTotalSupplyInWei()}")

            //account
            Log.d(TAG, "The Account Status is: ${account.getNetworkStatus()}")
            Log.d(TAG, "The Account Message is: ${account.getNetworkMessage()}")
            Log.d(TAG, "The Account Balance is: ${account.getBalance("0x82e4499D4b2A669831a3881d61BB24f7b620c61a")}")
            Log.d(TAG, "The Account(1) Balance is: ${account.getMultiBalance(threeAddresses())?.get(1)?.balance}")
            Log.d(TAG, "The Account Size of Blocks is: ${account.getBlocks("0x82e4499D4b2A669831a3881d61BB24f7b620c61a")?.size}")
            Log.d(TAG, "The Account Size of Transactions is: ${account.getTransactions("0x82e4499D4b2A669831a3881d61BB24f7b620c61a")?.size}")

            //transactions
        }
    }

    fun threeAddresses(): ArrayList<String> {
        val address = ArrayList<String>()
        address.add("0x82e4499D4b2A669831a3881d61BB24f7b620c61a")
        address.add("0x63a9975ba31b0b9626b34300f7f627147df1f526")
        address.add("0x198ef1ec325a96cc354c7266a038be8b5c558f67")
        return address
    }

}