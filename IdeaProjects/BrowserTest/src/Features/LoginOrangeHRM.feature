Feature: Verify the login.

  Scenario: Verify the login with invalid user name and password.
    Given The login page is loaded.
    When  I type invalid username "ffasf" and password "dfdg".
    And I click on the login button.
    Then Error message should be dispalyed as "Invalid credentials"



  Scenario Outline: Verify the login with invalid user name and password.
    Given The login page is loaded.
    When  I type invalid username "<username>" and password "<password>".
    And I click on the login button.
    Then Error message should be dispalyed as "<errorMessage>".
    Examples:
      |  |username|password|errorMessage|
      |  |Admin||Password cannot be empty|
      |  ||admin|Username cannot be empty|

