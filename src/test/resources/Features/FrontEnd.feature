Feature: To Test the rows displayed in UI
Scenario Outline: To Test the 100 rows displayed in UI
Given User is on login page
When user selected option "<option>" in select dropdown 
Then user should see row count as "<option>" 

Examples:
|option|
|100|
