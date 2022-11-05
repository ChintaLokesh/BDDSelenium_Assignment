Feature: To verify the filter search options
Scenario Outline:To verify the filter search options for MarketCap and Price
Given User is on Homepage
When User Click on "Filters" button and filter records by MarketCap with value "<MarketCap>" and Price with value "<Price>"
Then verify records displayed on page are correct as per the filters "<MarketCap>" and "<Price>" applied

Examples:
|MarketCap|Price|
|$1B - $10B|$101 - $1,000|