#Author: Keneth Aponte

@Callcenter
Feature: End to End scenarios
End to End test cases


      
  @E2E
Scenario: creating a ride with new driver

 Given I open EDGE
      Then I open the vehicle web page
      And I log in
      Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data'
      Then I click add new vehicle
      And populate new vehicle info
      Then I validate the vehicule created
  
      Then I open the driver web page
      Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data'
      Then I click add new driver
      And populate new driver info
      Then I validate the driver created
      
      Then I sign up in the driver app
      And I validate the driver name
  Given I select an available vehicle
  Then I select shift hours
  And I click start
  
  Then I open the call center web page      
  Then I click the BOOK A RIDE btn
  And I populate the ride information
  And I click timing: NEXT AVAILABLE
  Then I click SCHEDULE RIDE btn
  Then I click on the first row
  And I assign a driver
  #Why we need to click next available again? is it a bug?
  And I click timing: NEXT AVAILABLE
  Then I click SAVE CHANGES btn
 

