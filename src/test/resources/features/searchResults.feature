Feature:As a user, I should be able to login as librarian. When I go to Users
  page, table
  should have following columns:
  • Actions
  • UserID
  • Full Name
  • Email
  • Group
  • Status

  Background:
    Given user is on the login page
    Given User logged in as a librarian


  Scenario:User Manager Page table header verification
    When Librarian click on Users link
    Then table should have following column names:

      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |

