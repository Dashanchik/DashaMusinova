Feature: Simple Cucumber Test

  Scenario: Login verification
    Given I open EPAM JDI site
    When I login as user 'PITER_CHAILOVSKII'
    Then User name should be 'PITER_CHAILOVSKII'