Feature: To Retrieve the details of the currency
Scenario Outline: Retrieve the details of the currency
Given coinmarketcap base uri is available 
When Authorization is provided as header
Then verify the details for the id "<id>" like logo "<logo>", technical_doc "<technical_doc>", symbol "<symbol>", date_added "<date_added>" and tags "<tags>"   

Examples:
|id|logo|technical_doc|symbol|date_added|tags|
|1027|https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png|[https://github.com/ethereum/wiki/wiki/White-Paper]|ETH|2015-08-07T00:00:00.000Z|mineable|


Scenario Outline: Retrieve the first 10 currencies from the cryptocurrency/info call
Given coinmarketcap base uri is available
When Authorization is provided as header
Then verify the currencies name "<currencyName>" with Id's "<id>" have the "mineable" tag associated with them 

Examples:
|id|currencyName|
|1|Bitcoin|
|2|Litecoin|
|3|Namecoin|
|4|Terracoin|
|5|Peercoin|
|6|Novacoin|
|7|Devcoin3|
|8|Feathercoin|
|9|Mincoin|
|10|Freicoin|

