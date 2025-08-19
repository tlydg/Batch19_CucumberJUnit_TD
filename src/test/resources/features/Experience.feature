Feature: Experience Tests


  Scenario: Add Experience Form Labels Check
    Given The user is on the login page
    When The user logins with "test22mail@gmail.com" and "654321Abc,"
    Then The user should be able to see "testdeneme" on dashboard page
    When The user click on tab: "testdeneme" on module: "My Profile"
    Then The user should be able to see related page title with two parts: "User Profile"
    When The user navigates user profile tab menu with: "Add Experience"
    Then The user should be able to verify add experience form labels with following list
      | Job Title *     |
      | Company *       |
      | Location        |
      | From Date       |
      | To Date         |
      | Job Description |
