
Feature: Registration

Scenario: Successful registration with valid details
Given User should launch browser
When User open url "https://www.naukri.com/" 
And User click on Register link
Then Registration detail page is opened
And User enter full name
And User enter emailid
And User enter password
And User enter mobile no
And User attach a file


