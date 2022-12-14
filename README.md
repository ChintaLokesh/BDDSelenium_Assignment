# BDDSelenium_Assignment
This project describes about the **BDD Selenium scripts** for webapp and **API's Automation** using Rest Assured



**BDD-Cucumber with TEST NG** framework is used to create the test scripts 


Project File Description :
-------------------------------------------------------------------------------------------------

**Assignment Task Name**   |                      **Feature file Name**                                                   |              **step definition package and file name**    | 

-------------------------------------------------------------------------------------------------




**Backend Task1**   |          src\test\resources\Features\RetrieveId.feature                                     | src\test\java\com\cucumber\stepdefs\RetrieveIdTest.java |


**Backend Task2**   |          src\test\resources\Features\CurrencyDetails.feature                               |  src\test\java\com\cucumber\stepdefs\RetrieveIdTest.java |



**Backend Task3**   |          src\test\resources\Features\CurrencyDetails.feature                               |  src\test\java\com\cucumber\stepdefs\RetrieveIdTest.java |



**Frontend Task1**  |         src\test\resources\Features\FrontEnd.feature                                        |src\test\java\com\cucumber\stepdefs\CoinMarketCapTest.java |


**Frontend Task2**  |          src\test\resources\Features\FilterSearchResults.feature                             |src\test\java\com\cucumber\stepdefs\FilterSearchTest.java |


-------------------------------------------------------------------------------------------------

**Execution details** : 

To Run all the test scripts use maven command 



**For Edge Browser**   : **mvn clean test -DbrowserName=edge**



**For Chrome Browser**  : **mvn clean test -DbrowserName=chrome**




mvn command :  " mvn clean test "  will trigger the test scripts using edge browser 




(OR)



Once the project is cloned , open the file " src\test\java\com\cucumber\runner\TestRunner.java " --> Run As --> TestNG Test ( using Eclipse Editor )



Once the execution is completed , Extent Report along with the UI screenshots  are stored in " Reports " folder


NOTE : To make the scripts work using Github Actions , ChromeOptions property is set  to headless

Automation Extent Report is implemented to view the screenshots after Execution


![image](https://user-images.githubusercontent.com/22152001/200149712-af85efc1-4698-47a6-b9a7-47004f50598c.png)



Automation Extent Report for Frontend Task1



![image](https://user-images.githubusercontent.com/22152001/200149687-02311c83-9dae-478d-a0ea-b4a43f0d9f88.png)




Automation Extent Report for Frontend Task2



![image](https://user-images.githubusercontent.com/22152001/200149611-13ec7a5d-b74a-40c6-844e-9a911cecb506.png)


![image](https://user-images.githubusercontent.com/22152001/200149673-f6fbee35-4dec-435e-98cf-9bcaa3fe510b.png)




**In addition** : Automation is integrated with github actions 



Github Action workflow is created under  " **.github/workflows** " folder 



Navigate to  " Actions " tab , select  " **Sanity_BDD_Cucumber** " --> click on  " **Run Workflow** " {displayed on right side of the screen }



Screenshtots are given below for reference 


**Screenshot1**  - Click on **Actions** 


![image](https://user-images.githubusercontent.com/22152001/200112802-b4393ce4-300b-43e1-88c2-0e50fabb9d9e.png)

**Screenshot2**  - Select **Sanity_BDD_Cucumber**



![image](https://user-images.githubusercontent.com/22152001/200112916-a295023c-b32d-46e3-80e7-d0f0bd48f239.png) 

**Screenshot3** - Click on "**Run Workflow** "



![image](https://user-images.githubusercontent.com/22152001/200112947-c34a7417-1371-4b8b-950b-31ea1e114ef5.png) 


![image](https://user-images.githubusercontent.com/22152001/200114146-f11aabcd-7c09-4ba1-bca9-4c00f7914401.png)





**Screenshot4**  - **Automation Execution Screen using Github Action**



![image](https://user-images.githubusercontent.com/22152001/200113373-912eb7a5-200d-4397-9d3d-74c48249965b.png)

**Screenshot5**  - "**Github action Completion Screen**"



![image](https://user-images.githubusercontent.com/22152001/200113411-1339d995-983d-4871-9c10-c318779c9884.png)



![image](https://user-images.githubusercontent.com/22152001/200149971-80641c34-c5be-4ee4-a657-7da42d263cd1.png)





After Successfull execution , "Reports" folder is automatically committed and can view the results by downloading the " .html " files 


"screenshot6" - Test Execution status showing as  " Passed "




![image](https://user-images.githubusercontent.com/22152001/200117032-a10b79b7-d4b2-47b5-b689-6866b065da5c.png)




**Screenshot7** - " **screenshots folder got updated in Github Repo** "


![image](https://user-images.githubusercontent.com/22152001/200149884-de3bf368-ac75-474f-ab79-b546cc5cf36e.png)


**Screenshot8** - " **Reports folder got updated in Github Repo** "



![image](https://user-images.githubusercontent.com/22152001/200113460-aab59ce7-7fe4-440b-9c63-e6a1692b65bb.png)






