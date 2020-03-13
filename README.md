# POC
c28 Automation Test_Results
------------------------------------------------------------------------------------------------------------------------------------
Assumptions: Test Scripts has been created on the assumption that data on the portal is static

#Cucumber, TestNG, Selenium

Instructions for setup and script execution:

1. Install Java and eclipse in your machine (Java version used is "1.8.0_211")
2. Get the project from GitHub
3. Import project to eclipse
4. Verify the libraries are mapped and are displayed in the project without any errors(JRE library and custom .jar files)
5. Clean and Build the project
6. Run the project from testng_parallelTests.xml as TestNG test
---------------------------------------------------------------------------------------------------------------------------------------

Features

Feature files has been created for the mentioned tests which are placed in Features folder and are as given below:

1. Header_Verification.feature---Feature for header validation
2. Footer_Verification.feature---Feature for footer validation
3. Newsletter_Subscription.feature---Feature for newsletter subscription validation
4. DressesPage_Verification.feature---Feature for summer dresses page validation
5. Checkout_Journey.feature---Feature for checkout journey validation

----------------------------------------------------------------------------------------------------------------------------------------

Test Script Details(Step Defintions):

Step Definitions have been created for all of the feature files as given below:

1. TS_VerifyHeader.java---Test case will verify the headers for different pages
2. TS_VerifyFooter.java---Test case will verify different sections in the footer 
3. TS_NL_Subscription.java---Test case will validate newsletter subscription
4. TS_DressesPageVerification.java---Test case will validate the navigation to Summer Dresses listing page and different options available there
5. TS_CheckOut_Journey.java---Test case will verify the checkout journey by adding any product to the cart(till authentication section is reached)

Note: Filter and Sort in SummerDresses page will make the page hang because of which the results(with filter/sort applied) is not validated
i.e. Then case is not validated

Tests can be run in any browser, default browser selected is chrome
Parallel execution of tests will be performed using testng_parallelTests.xml file
----------------------------------------------------------------------------------------------------------------------------------------
Test Results:

After execution is complete, output can be verified from test-output->html-> folder->index.html file.
Open the file as Webbrowser, the Overview section displays the result of every test performed. The detailed report can be viewed when the suite link is clicked
----------------------------------------------------------------------------------------------------------------------------------------
