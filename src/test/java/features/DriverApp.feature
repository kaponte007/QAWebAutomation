#Author: Keneth Aponte

@DriverApp
Feature: Driver scenarios
Test cases in driver app

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
   #   And I validate the vehicle is listed
  

