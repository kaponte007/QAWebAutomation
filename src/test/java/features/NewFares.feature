#Author: Keneth Aponte

@Callcenter2
Feature: Callcenter scenarios
Test cases in call center web page

Background:
 Given I open CHROME
      Then I open the call center web page
      And I log in
      
 
 @BaseFare_Wheelchair
 Scenario: Copying from an existing ride 
  T#hen I click make a copy from first row
     Then I click the BOOK A RIDE btn
  And I populate ride using data from 'testingDataExcel.xlsx' sheet 'Data3'
   And I click timing: NEXT AVAILABLE
  Then I click SCHEDULE RIDE btn

