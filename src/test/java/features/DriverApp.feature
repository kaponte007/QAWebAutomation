#Author: Keneth Aponte

@DriverApp
Feature: Driver app scenarios
Test cases in driver app

@Driverapp_logIn
 Scenario: Log In
 Given I open EDGE
  Then I open the driver app
  And I log in driverapp
  And I validate the log in
    
@Driverapp_SignUp
  Scenario: Sign Up
      Given I open EDGE
      Then I open the driver web page
      And I log in
      Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data'
      Then I click add new driver
      And populate new driver info
      Then I validate the driver created
      Then I sign up in the driver app
      And I validate the driver name

 @Driverapp_UpdatingShift
Scenario: updating shift
  Given I open EDGE
  Then I open the driver app
  And I log in driverapp
  And I validate the log in
  Given I select an available vehicle
 # Then I select shift hours
 # And I click start
 
