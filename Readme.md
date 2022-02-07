# Flipkart Website Automation Suite information:-

### To run the Flipkart website automation through maven

### Packages description
- com.FlipkartProject.utils : Defining all the utilities needed for the tests.
- com.FlipkartProject.Pages : Defining all the pages actions and the respective object repository. 
- com.FlipkartProject.Tests : Defining all the pages tests and assertions.

### Tests.java files description

**AddToCartTest** : Includes Test
- To verify the product is adding to the cart

**ElectronicsTest** : Includes Test
- To verify the user is able to navigate to the electronics menu

**FashionTest** : Includes Test
- To verify the user is able to navigate to the fashion menu

**FiltersTest** : Includes Test
- To verify the user is able to see the products with different filters

**GroceryTest** : Includes Test
- To verify the user is able to navigate to the grocery section

**LoginTest** : Includes Test
- To verify login when the user name & password is correct
- To verify login when the user name is incorrect & password is correct
- To verify logout after login

**MyOrdersTest** : Includes Test
- To verify the recent prder
- To verify the past order in 2020
- To verify the add review option

**MyProfileTest** : Includes Test
- To verify the add address option
- To verify the recent address deletion

**PageNavigationTest** : Includes Test
- To verify that after search at the bottom of the page there should be a button to go on next page
- To verify that after clicking on page two the website should redirect the user to second page 

**ProductSpecificationTest** : Includes Test
- To verify the change color and storage
- To verify the reviews
- To verify the change pincode

**SearchProductTest** : Includes Test
- To verify the product adding to the wishlist
- To verify the product deleting from the wishlist

**BaseTest** : Includes Test
- @BeforeMethod : To initialize the chrome/firefox/edge browser
- @AfterMethod  : To quit the browser
- @BeforeSuite  : To generate report


### Other files description
<ul>
  <li>Screenshots.java : defines function to take screenshot</li>
  <li>ExcelFileIO.java : defines function to read data from excel file</li>
  <li>CommonUtils.java : defines function for execution required field</li>
  <li>ExtentReport.html : defines report for all the running test cases with description</li>
  <li>TestData.xlsx : defines the excel sheet for test data</li>
  <li>Config.properties : defines url for different web browsers,uncomment the browser on which the test cases should run</li>             
</ul>

### Reports and Screenshots
<ul>
  <li>Extent report gets generated after the run under \ExitProjectAssignment\Reports\ExtentReport.html</li>
  <li>Logs gets generated after the run under \ExitProjectAssignment\Reports\Flipcart.log</li>
  <li>TestNG report as "emailable-report.html" gets generated under\test-output</li>
  <li>Screenshots gets placed under \FailedScreenshots folder with test name</li>
</ul>

### GitHub repository link
<ul>
  <li>https://github.com/Nainasingh99711/SeleniumAutomationFramework.git</li>
</ul>

### How to run the script
- Import the project in eclipse
- From \ExitProjectAssignment\Resources\config.properties choose the desired browser in which we want to run the test cases
- Uncomment the browser name
- Run the project through Maven or TestNG or cmd






