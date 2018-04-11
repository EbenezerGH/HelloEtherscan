package jfyg.account

import jfyg.model.Balances
import jfyg.model.Blocks
import jfyg.model.Transactions
import jfyg.queries.QueryMediator
import jfyg.utils.QueryUtils

class Account : AccountContract {

    private val query = QueryMediator()
    private val genericNetworkQuery = query.accountBalance("account", "balance",
            "0x82e4499D4b2A669831a3881d61BB24f7b620c61a", "latest")

    private val queryUtil = QueryUtils()

    override fun getBalance(account: String?): Double? =
            query.accountBalance("account", "balance",
                    account, "latest").let { query.fetchAccountBalance()?.result?.toDouble() }


    override fun getMultiBalance(accounts: ArrayList<String>?): ArrayList<Balances>? =
            query.accountMultiBalance("account", "balancemulti",
                    queryUtil.retrieveAccounts(accounts), "latest").let { query.fetchAccountMultiBalance()?.result }

    //todo #29
    override fun getBlocks(account: String?): ArrayList<Blocks>? =
            query.accountBlock("account", "getminedblocks",
                    account, "blocks").let { query.fetchAccountBlock()?.result }

    //todo #29
    override fun getTransactions(account: String?): ArrayList<Transactions>? =
            query.accountTransactions("account", "txlist",
                    account, "0", "99999999",
                    "asc").let { query.fetchAccountTransaction()?.result }

    override fun getNetworkStatus(): String? = genericNetworkQuery.let { query.fetchAccountBalance()?.status }

    override fun getNetworkMessage(): String? = genericNetworkQuery.let { query.fetchAccountBalance()?.message }

}