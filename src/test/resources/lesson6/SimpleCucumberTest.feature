Feature: Simple Cucumber Test

  Scenario: Login verification
    Given I open EPAM JDI site
    When I login as user 'PITER'
    Then User name should be 'PITER'