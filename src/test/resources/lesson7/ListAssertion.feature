Feature: User can login to EPAM JDI site and sees the Home page

  @UserTablePageTest
  Scenario: Login as a user to EPAM JDI site
    Given I open EPAM JDI page
    And I login as a user 'PITER CHAILOVSKII'
    And I click on 'Service' button in Header
    And I click on 'User Table' button in Service dropdown
    Then 'User Table' page is opened
    And User table contains following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
