Feature: Login and ForgetPassword

Background:
Given User should launch browser
When User open url "https://www.naukri.com/" 
And User Click on login button

@Regression @Smoke
Scenario: Successful login with valid credentials
And User enters valid Emailid as "gaurav1ahuja1@gmail.com" and Password as "Gauravnaukri@12345"
And User click on login
Then User should be able to redirect to the homepage
And User should verify the Url
And Close the browser

Scenario: Check OTP received with valid EmailId
And User Click on forget password link
Then Link should be redirected to New Tab
And Enter valid Emailid
|Emailid|
|abc@gmail.com|
|gaurav1ahuj@gmail.com|


# ctrl + / for commenting in feature file

Scenario Outline: Successful login with valid credentials
And User enters valid Emailid as "<EmailId>" and Password as "<Password>"
And User click on login
Then User should be able to redirect to the homepage
And User should verify the Url
And Close the browser

Examples:
|EmailId|Password|
|gaurav1ahuja1@gmail.com|Gauravnaukri|
|gaurav1ahuja1@gmail.com|Gauravnaukri@12345|
|Gauravnaukri|Gauravnaukridd|



