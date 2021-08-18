#Author: Keneth Aponte

@Callcenter
Feature: Callcenter scenarios
Test cases in call center web page

Background:
 Given I open EDGE
      Then I open the call center web page
      And I log in
      
@ride_new
  Scenario: Creating a new ride    
      Then I click the BOOK A RIDE btn
      And I populate the ride information
      And I click timing: NEXT AVAILABLE
      Then I click SCHEDULE RIDE btn
 
 @ride_copy
 Scenario: Copying from an existing ride 
  Then I click make a copy from first row
   And I click timing: NEXT AVAILABLE
  Then I click SCHEDULE RIDE btn

