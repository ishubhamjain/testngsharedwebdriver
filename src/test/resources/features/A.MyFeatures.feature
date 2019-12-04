#Author: Shubham Jain
#Email: ishubhamjain@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Automation goibobo feature file name

  Background:
  Given User logs into the application and on the home page
  
  Scenario: postive scenario
  Given verify if GoIbibo homepage goibibo works as expected
  When search for one-way flights between "Bengaluru" and "Mumbai"
  Then verify if the page results are ordered in decreasing order of cost
  
  Scenario: Negative scenario - Source and Destination is same
  Given verify if GoIbibo homepage goibibo works as expected
  When search for one-way flights between "Bengaluru" and "Bengaluru"
  Then An error message should appears and no search process should initiate
  
  Scenario: Negative scenario - Select an old date for flight booking
  Given verify if GoIbibo homepage goibibo works as expected
  When search for one-way flights between "Bengaluru" and "Mumbai" on old date
  Then Old date must not be selected
  

  
 
