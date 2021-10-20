Feature: Login Scenarios

  @logintest
  Scenario: Validating Login Process

    Given User Launch browser

    When User enter "standard_user" and "secret_sauce"

    Then User should able to login successfully