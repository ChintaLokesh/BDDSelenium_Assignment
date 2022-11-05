# BDDSelenium_Assignment
This project describes about the BDD Selenium scripts for webapp and API's using Rest Assured
BDD-Cucumber with TEST NG framework is used to create the test scripts 


Project File Description :
-------------------------------------------------------------------------------------------------

Task Name         Feature file Name                                                                   step definition package and file name 

Backend Task1     src\test\resources\Features\RetrieveId.feature                                      src\test\java\com\cucumber\stepdefs\RetrieveIdTest.java
Backend Task2     src\test\resources\Features\CurrencyDetails.feature                                 src\test\java\com\cucumber\stepdefs\RetrieveIdTest.java
Backend Task3     src\test\resources\Features\CurrencyDetails.feature                                 src\test\java\com\cucumber\stepdefs\RetrieveIdTest.java

Frontend Task1    src\test\resources\Features\FrontEnd.feature                                        src\test\java\com\cucumber\stepdefs\CoinMarketCapTest.java
Frontend Task2    src\test\resources\Features\FilterSearchResults.feature                             src\test\java\com\cucumber\stepdefs\FilterSearchTest.java


-------------------------------------------------------------------------------------------------

Execution details : 

Run all the test scripts using maven command 

For Edge Browser    : mvn clean test -DbrowserName=edge
For Chrome Browser  : mvn clean test -DbrowserName=chrome

(OR)

once the project is cloned , open the file " src\test\java\com\cucumber\runner\TestRunner.java " --> Run As --> TestNG Test

Once the execution is completed , Extent Report along with the UI screenshots  are stored in " Reports " folder


In addition : Automation is integrated with github actions 

Github Action workflow is created under  " .github/workflows " folder 

Navigate to  " Actions " tab , select  " Sanity_BDD_Cucumber " --> click on  " Run Workflow " {displayed on right side of the screen }

![image](https://user-images.githubusercontent.com/22152001/200112802-b4393ce4-300b-43e1-88c2-0e50fabb9d9e.png) -> Screenshot1

![image](https://user-images.githubusercontent.com/22152001/200112916-a295023c-b32d-46e3-80e7-d0f0bd48f239.png) -> Screenshot2

![image](https://user-images.githubusercontent.com/22152001/200112947-c34a7417-1371-4b8b-950b-31ea1e114ef5.png) -> Screenshot3

![image](https://user-images.githubusercontent.com/22152001/200112970-a2b70184-2de2-4a92-b8b0-2c85f6752324.png)  -> Screenshot4

NOTE : please copy and paste the links above to view the workflow navigation screenshots  




After Successfull execution , "Reports" folder is automatically committed and can view the results by downloading the " .html " files 





