Feature: Login Function

  # for comment - yorum satırı

  #user story = feature
  #test case = scenario
  #test step = Given, When, Then etc..

  Scenario: Login as testdeneme
    Given The user is on the login page
    When The user enters testdeneme's credentials
    Then The user should be able to see dashboard page

  Scenario: Login as mike
    Given The user is on the login page
    When The user enters mike's credentials
    Then The user should be able to see dashboard page

    # class task create a scenario for login test with Leroy

  Scenario: Login as Leroy
    Given The user is on the login page
    When The user enters Leroy's credentials
    Then The user should be able to see dashboard page

