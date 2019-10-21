[![Generic badge](https://img.shields.io/badge/EtherscanApi-UP-brightgreen.svg)](https://api.etherscan.io/api?module=stats&action=ethprice&apikey=YourApiKeyToken)
[![Generic badge](https://img.shields.io/badge/CircleCI-PASS-brightgreen.svg)](https://circleci.com/gh/EbenezerGH/hello_etherscan/tree/master)
[![Generic badge](https://img.shields.io/badge/Version-v1.4.0-lightgrey.svg)](https://jitpack.io/#EbenezerGH/etherscan-android-api)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/EbenezerGH/hello_etherscan/blob/update-documentation/LICENSE)

# etherscan-android-api

[![Join the chat at https://gitter.im/etherscan-android-api/Lobby](https://badges.gitter.im/etherscan-android-api/Lobby.svg)](https://gitter.im/etherscan-android-api/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

etherscan android api is an android wrapper for the [etherscan api](https://etherscan.io/apis).  This is just a module to handle networking calls.

There are only a few [features](https://github.com/EbenezerGH/hello_etherscan/issues) left to add, however this version is completely safe to use.

##### Note: For Coroutines Implementation use coroutines-master branch [etherscan-coroutines](https://github.com/EbenezerGH/etherscan-android-api/tree/master-coroutines)

## Getting Started

Add JitPack to your root build.gradle at the end of repositories
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```


Add the dependency


```
	dependencies {
	        implementation 'com.github.EbenezerGH:etherscan-android-api:v1.4.0'
	}
```


Optional: Call `ApiKey.takeOff.setApiKey("[your api key here]")` in your module's application class when recording api usage in the etherscan.io console. [see [example implementation](https://github.com/EbenezerGH/etherscan-android-api/blob/master/etherscan-sample/src/main/java/jfyg/etherscan/helloetherescan/EtherscanSampleApplication.kt)]
```
ApiKey.takeOff.setApiKey("1I7CRNU2QIU253UBPFVB5UV2C2PBDURAIYZ")
```

Create an Instance of one of the reactive singles and access values by specifying thread and subscribing. [see [example implementation](https://github.com/EbenezerGH/etherscan-android-api/blob/master/etherscan-sample/src/main/java/jfyg/etherscan/helloetherescan/SampleActivity.kt)]

Currently Available: ``[accountsApi, contractsApi, transactionsApi, blocksApi, statApi]``

Coming Soon: ``[eventLogs, geth, websockets, tokens]``

```
        val account = Account()
        val contract = ContractABI()
        val blocks = BlocksMined()

            //account
            account.getERC20Tokens("0x4e83362442b8d1bec281594cea3050c8eb01311c")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = { Log.d(TAG, "The Account Size of Transactions is: ${it.size}") },
                            onError = { Log.d(TAG, "error receiving ERC20") })

            //contracts
            contract.getContractABI("0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = { Log.d(TAG, "The ABI has returned: $it") },
                            onError = { Log.d(TAG, "error receiving abi contract") })

            //blocks
            blocks.getBlocksMined("2165403")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = {
                                Log.d(TAG, "The block miner is: ${it.blockMiner} and " +
                                        "the first miner : ${it.uncles.get(0).miner}")
                            },
                            onError = { Log.d(TAG, "error receiving blocks mined") })
```
## Authors

* [**Ebenezer Ackon**](http://www.ebenezerackon.com/)

```
BTC: 1MLaf31sjVG3LbMyQEuY16qosPAhwNRQeZ
ETH: 82e4499D4b2A669831a3881d61BB24f7b620c61a
LTC: LUF9RpzZ3kyKMYpSNiAT5hx7qR3q7ShV3H
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## References

[**Etherscan APIs**](https://etherscan.io/apis)

[**Contracts Verified**](https://etherscan.io/contractsVerified)

[**Ethereum Github Repo**](https://github.com/ethereum)

[**Ethereum Wiki**](https://github.com/ethereum/wiki/wiki/JSON-RPC)


