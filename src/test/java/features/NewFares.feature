#Author: Keneth Aponte

@Callcenter2
Feature: Callcenter scenarios
Test cases in call center web page

Background:
 Given I open CHROME
      Then I open the call center web page
      And I log in
      
 
 @BaseFare_Wheelchair
 Scenario: BaseFare_Wheelchair
  Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data3'
  Then I click the BOOK A RIDE btn
  And I populate rider info using data from excel
  And I populate trip info using data from excel
  And I populate timing info using data from excel
  Given I select the ride service name
  Then I validate the fare
  Then I click SCHEDULE RIDE btn

 @Extra_Wheelchair
 Scenario: ExtraFare_Wheelchair
  Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data4'
  Then I click the BOOK A RIDE btn
  And I populate rider info using data from excel
  And I populate trip info using data from excel
  And I populate timing info using data from excel
  Given I select the ride service name
  Then I validate the fare
  Then I click SCHEDULE RIDE btn
  
   @BaseFare_hospital
 Scenario: BaseFare_Hospital
  Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data6'
  Then I click the BOOK A RIDE btn
  And I populate rider info using data from excel
  And I populate trip info using data from excel
  And I populate timing info using data from excel
  Given I select the ride service name
  Then I validate the fare
  Then I click SCHEDULE RIDE btn

 @Extra_hospital
 Scenario: ExtraFare_Hospital
  Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data5'
  Then I click the BOOK A RIDE btn
  And I populate rider info using data from excel
  And I populate trip info using data from excel
  And I populate timing info using data from excel
  Given I select the ride service name
  Then I validate the fare
  Then I click SCHEDULE RIDE btn
  
     @BaseFare_stretcher
 Scenario: BaseFare_stretcher
  Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data7'
  Then I click the BOOK A RIDE btn
  And I populate rider info using data from excel
  And I populate trip info using data from excel
  And I populate timing info using data from excel
  Given I select the ride service name
  Then I validate the fare
  Then I click SCHEDULE RIDE btn

 @Extra_stretcher
 Scenario: ExtraFare_stretcher
  Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data8'
  Then I click the BOOK A RIDE btn
  And I populate rider info using data from excel
  And I populate trip info using data from excel
  And I populate timing info using data from excel
  Given I select the ride service name
  Then I validate the fare
  Then I click SCHEDULE RIDE btn
  
       @BaseFare_holiday
 Scenario: BaseFare_holiday
  Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data9'
  Then I click the BOOK A RIDE btn
  And I populate rider info using data from excel
  And I populate trip info using data from excel
  And I populate timing info using data from excel
  Given I select the ride service name
  Then I validate the fare
  Then I click SCHEDULE RIDE btn

 @Extra_holiday
 Scenario: ExtraFare_holiday
  Given I upload testing data from 'testingDataExcel.xlsx' sheet 'Data10'
  Then I click the BOOK A RIDE btn
  And I populate rider info using data from excel
  And I populate trip info using data from excel
  And I populate timing info using data from excel
  Given I select the ride service name
  Then I validate the fare
  Then I click SCHEDULE RIDE btn
