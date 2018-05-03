package jfyg.data

data class BlockMined(var blockNumber: String? = null,

                      var timeStamp: String? = null,

                      var blockMiner: String? = null,

                      var blockReward: String? = null,

                      var uncles: List<Uncle> = emptyList()) //test