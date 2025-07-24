Feature: Login Functionality

  Background:
    Given I am on the login page

  Scenario: Invalid username login
    When I login with username "WrongUserName" and password "<valid_password>"
    Then I should see login failure message

  Scenario: Invalid password login
    When I login with username "<valid_username>" and password "WrongPassword"
    Then I should see login failure message

  Scenario: Invalid username and password login
    When I login with username "WrongUserName" and password "WrongPassword"
    Then I should see login failure message

  Scenario: Locked out user login
    When I login with username "<locked_out_username>" and password "<valid_password>"
    Then I should see login failure message

  Scenario: Valid login
    When I login with username "<valid_username>" and password "<valid_password>"
    Then I should see login success
