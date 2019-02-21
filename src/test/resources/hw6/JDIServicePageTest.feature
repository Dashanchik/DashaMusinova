Feature: User can login to EPAM JDI site and sees the Home page

  # TODO Where is Then? - fixed
  # TODO I can select checkbox 'Wind' and the selection is logged - this is not good idea - fixed
  #     combine action and assertion steps into one
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
    Then I see all needed elements on the Different Elements Page
    And I see the left section
    And I see the right section
    When I select checkbox 'Wind'
    Then The selection of 'Wind' is logged
    And I select checkbox 'Water'
    Then The selection of 'Water' is logged
    And I can select radiobutton 'Selen' and the selection is logged
    And I can select dropdown 'Yellow'
    When I select checkbox 'Water'
    Then The deselection of 'Water' is logged
    When I select checkbox 'Wind'
    Then The deselection of 'Wind' is logged


