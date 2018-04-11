package jfyg.account

import jfyg.model.Balances
import jfyg.model.Blocks
import jfyg.model.Transactions

interface AccountContract {

    /**
     * Return network status
     */
    fun getNetworkStatus(): String?

    /**
     * Return network message
     */
    fun getNetworkMessage(): String?

    /**
     * Return account balance
     */
    fun getBalance(account: String?): Double?

    /**
     * Return balances of multiple accounts separated by commas
     */
    fun getMultiBalance(accounts: ArrayList<String>?): ArrayList<Balances>?

    /**
     * Get list of blocks mined by address
     */
    fun getBlocks(account: String?): ArrayList<Blocks>?

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    fun getTransactions(account: String?): ArrayList<Transactions>?

}