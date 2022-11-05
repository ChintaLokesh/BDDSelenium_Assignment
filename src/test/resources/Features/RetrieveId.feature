Feature: To Retrieve the ID
Scenario Outline: Retrieve the ID of bitcoin (BTC), usd tether (USDT), and Ethereum (ETH), using the /cryptocurrency/map call
Given coinmarketcap base uri is available
When Authorization is provided as header
Then Retrieve the Id for name "<Name>" with symbol "<Symbol>"
And extract the price of the Bolivarcoin "<Name>" with symbol "<Symbol>"
Examples:
|Name|Symbol|
|bitcoin|BTC|
|tether|USDT|
|Ethereum|ETH|
|Bolivarcoin|BOLI|





