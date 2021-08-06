#Author: Keneth Aponte

@Vehicle
Feature: Vehicle scenarios
Test cases in vehicle web page

  Scenario: Creating a new vehicle
      Given I open EDGE
      Then I open the vehicle web page
      And I log in
      Then I click add new vehicle
      And populate new vehicle info
      Then I validate the vehicule created
  

