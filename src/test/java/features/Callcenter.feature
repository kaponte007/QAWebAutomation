#Author: Keneth Aponte

@Callcenter
Feature: Callcenter scenarios
Test cases in call center web page

  Scenario: Creating a new ride
      Given I open EDGE
      Then I open the call center web page
      And I log in
      Then I click the BOOK A RIDE btn
      And I populate the ride information
      And I click timing: NEXT AVAILABLE
      Then I click SCHEDULE RIDE btn
  
  

