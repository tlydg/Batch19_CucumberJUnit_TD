Feature: Education Tests

  Scenario: Add Education Form Labels Check
    Given The user is on the login page
    When The user logins with "test22mail@gmail.com" and "654321Abc,"
    Then The user should be able to see "testdeneme" on dashboard page
    When The user click on tab: "testdeneme" on module: "My Profile"
    Then The user should be able to see related page title with two parts: "User Profile"
    When The user navigates user profile tab menu with: "Add Education"
    Then The user should be able to verify add education form labels with following list
      | School or Bootcamp *    |
      | Degree or Certificate * |
      | Study                   |
      | From Date               |
      | To Date                 |
      | Program Description     |


  Scenario Outline: Filling Education Form For Different Person <username>
    Given The user is on the login page
    When The user logins with "<email>" and "<password>"
    Then The user should be able to see "<username>" on dashboard page
    When The user click on tab: "<username>" on module: "My Profile"
    Then The user should be able to see related page title with two parts: "User Profile"
    When The user navigates user profile tab menu with: "Add Education"
    Then The user verifies that add education page is displayed
    When The user fills the aducation form with "<schoolName>" and "<degree>" and "<study>" and "<fromDate>" and "<toDate>" and "<desc>"
    Then The user should be able to veriy added education record with "<schoolName>"
    Then The user should be able to delete last added education record with "<schoolName>"
    Examples:
      | email                   | password   | username   | schoolName | degree   | study                        | fromDate | toDate   | desc  |
      | test22mail@gmail.com    | 654321Abc, | testdeneme | ITU        | Bachelor | Public Finance               | 11112011 | 10102015 | hard  |
      | rosa@test.com           | Test123456 | Rosa       | Ankara     | Master   | Architecture                 | 11112010 | 10102014 | nice  |
      | leeroyjenkins@email.com | 1234.Asdf  | Leeroy     | Bilkent    | PC       | Medicine                     | 11112012 | 10102016 | good  |
      | mike@gmail.com          | mike1234   | mike       | Koc        | Doctor   | Software Engineering Finance | 11112013 | 10102016 | sweet |



