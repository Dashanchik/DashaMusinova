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
    And See all needed elements on the Different Elements Page
    And I see the left section
    And I see the right section
    And I can select checkbox 'Wind' and the selection is logged
    And I can select checkbox 'Water' and the selection is logged
    And I can select radiobutton 'Selen' and the selection is logged
    And I can select dropdown 'Yellow'
    And I can unselect the checkbox 'Water' and the selection is logged
    And I can unselect the checkbox 'Wind' and the selection is logged


