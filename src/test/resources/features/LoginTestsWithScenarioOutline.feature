Feature: Login tests with scenario outline


  Scenario Outline: Positive Login Tests with <username>
    Given The user is on the login page
    When The user logins with "<email>" and "<password>"
    Then The user should be able to see "<username>" on dashboard page
    Examples:
      | email                   | password   | username   |
      | test22mail@gmail.com    | 654321Abc, | testdeneme |
      | rosa@test.com           | Test123456 | Rosa       |
      | leeroyjenkins@email.com | 1234.Asdf  | Leeroy     |
      | mike@gmail.com          | mike1234   | mike      |
      | Ramanzi@test.com        | Test123456 | Mansimmo   |


  Scenario Outline: Negative Login Tests
    Given The user is on the login page
    When The user logins with "<email>" and "<password>"
    Then The user should be able to see warning "<message>"
    Examples:
      | email                | password      | message                                  |
      | wrongmail@aaa.com    | 654321Abc,    | Email address is incorrect. Please check |
      | test22mail@gmail.com | wrongPassword | Password is incorrect. Please check      |
      |                      | 654321Abc,    | Please enter your email.                 |
      | test22mail@gmail.com |               | Please enter your password!              |
      |                      |               | Please enter your email.                 |