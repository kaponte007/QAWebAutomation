#Author: Keneth Aponte

@Driver
Feature: Driver scenarios
Test cases in driver web page

  Scenario: Creating a new driver
      Given I open EDGE
      Then I open the driver web page
      And I log in
      Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data'
      Then I click add new driver
      And populate new driver info
      Then I validate the driver created
  

