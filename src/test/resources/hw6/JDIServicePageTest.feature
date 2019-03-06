Feature: User can login to EPAM JDI site and sees the Home page

  @HomePageTest
  Scenario: Login as a user to EPAM JDI site
    Given I open EPAM JDI page
    When I login as a user 'PITER CHAILOVSKII'
    Then User name should be as 'PITER CHAILOVSKII'
    And I see the pictures and texts underneath them
      | To include good practices\nand ideas from successful\nEPAM project                          |
      | To be flexible and\ncustomizable                                                            |
      | To be multiplatform                                                                         |
      | Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more… |
    And There's Service Dropdown with the correct items in the header menu
    And There's Service Dropdown with the correct items in the sidebar menu
    When I click on 'Service' button in Header
    And I go to 'DIFFERENT ELEMENTS' Page
    Then I see 4 checkboxes, 4 radios, 2 buttons and 1 dropdown on the Different Elements Page
    And I see the left section
    And I see the right section
    When I select checkbox 'Wind'
    And I select checkbox 'Water'
    And I can select radiobutton 'Selen'
    And I can select dropdown 'Yellow'
    And I select checkbox 'Water'
    And I select checkbox 'Wind'
    Then I see following strings in the log
      | Wind: condition changed to false  |
      | Water: condition changed to false |
      | Colors: value changed to Yellow   |
      | metal: value changed to Selen     |
      | Water: condition changed to true  |
      | Wind: condition changed to true   |

