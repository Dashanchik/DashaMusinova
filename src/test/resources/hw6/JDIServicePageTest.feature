Feature: User can login to EPAM JDI site and sees the Home page

  @HomePageTest
  Scenario: Login as a user to EPAM JDI site
    Given I open EPAM JDI page
    When I login as a user 'PITER CHAILOVSKII'
    Then User name should be as 'PITER CHAILOVSKII'
    And I see the pictures and texts underneath them
    And There's Service Dropdown with the correct items in the header menu
    And There's Service Dropdown with the correct items in the sidebar menu
    When I click on 'Service' button in Header
    And I go to 'DIFFERENT ELEMENTS' Page
    # TODO What does it mean "Needed elements"?
    Then I see all needed elements on the Different Elements Page
    And I see the left section
    And I see the right section
    When I select checkbox 'Wind'
    Then The selection of 'Wind' is logged
    And I select checkbox 'Water'
    # TODO All steps which describe check logger could be combine into one
    Then The selection of 'Water' is logged
    # TODO Why is it combined into one step
    And I can select radiobutton 'Selen' and the selection is logged
    And I can select dropdown 'Yellow'
    When I select checkbox 'Water'
    Then The deselection of 'Water' is logged
    When I select checkbox 'Wind'
    Then The deselection of 'Wind' is logged


