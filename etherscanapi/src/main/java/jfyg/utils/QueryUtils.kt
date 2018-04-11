package jfyg.utils

/**
 * Utilities that may be used to provide successful Queries
 */
class QueryUtils {

    fun retrieveAccounts(accounts: ArrayList<String>?): String {

        var getAccounts = ""

        for (account in accounts!!) {
            getAccounts += account + ","
        }

        return getAccounts.dropLast(1)
    }

}