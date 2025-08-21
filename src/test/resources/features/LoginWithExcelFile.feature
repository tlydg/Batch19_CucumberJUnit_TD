Feature: Login Test With Excel File


  Scenario Outline: Login Test -1
    Given The user is on the login page
    When The user logins with using excel file: "<path>" and "<sheetName>" and <row>
    Then The user verifies success login with excel file:  "<path>" and "<sheetName>" and <row>
    Examples:
      | path                                           | sheetName | row |
      | src/test/resources/LoginList.xlsx              | QaTeam1   | 1   |
      | src/test/resources/LoginList.xlsx              | QaTeam1   | 2   |
      | src/test/resources/LoginList.xlsx              | QaTeam1   | 0   |
      | src/test/resources/LoginList.xlsx              | QaTeam2   | 8   |
      | src/test/resources/features/LoginList_New.xlsx | QaTeam2   | 9   |
      | src/test/resources/LoginList.xlsx              | QaTeam2   | 10  |
      | src/test/resources/LoginList.xlsx              | QaTeam3   | 0   |
      | src/test/resources/features/LoginList_New.xlsx | QaTeam3   | 1   |


  Scenario Outline: Login Test -2
    Given The user is on the login page
    When The user logins with using excel file: <row>
    Then The user verifies success login with excel file: <row>
    Examples:
      | row |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |
      | 6   |
      | 7   |

  @wip
  Scenario Outline: Login Test -3
    Given The user is on the login page
    When The user logins with using excel file: "<path>" and "<sheetName>" and makes verify
    Examples:
      | path                                           | sheetName |
      | src/test/resources/LoginList.xlsx              | QaTeam1   |
      | src/test/resources/LoginList.xlsx              | QaTeam2   |
      | src/test/resources/LoginList.xlsx              | QaTeam3   |
      | src/test/resources/features/LoginList_New.xlsx | QaTeam1   |
      | src/test/resources/features/LoginList_New.xlsx | QaTeam2   |
      | src/test/resources/features/LoginList_New.xlsx | QaTeam3   |









