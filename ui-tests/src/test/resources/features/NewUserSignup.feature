Feature: New User Signup
  As a new user
  I want to create an account
  So that I can access the website's feature

  Scenario: Successful signup with valid details
    Given I am on the Login page
    And I entered the "Satyajit Barman" and "satyajitb9947@gmail.com" in the New User Signup on the Login page
    And I clicked the button Signup in the New User Signup on the Login page
    When I enter valid details for a new user on the Signup page
      | TITLE | PASSWORD | DATE_OF_BIRTH   | NOTIFY_NEWSLETTER | NOTIFY_SPECIAL_OFFER | FIRST_NAME | LAST_NAME | COMPANY | ADDRESS1    | ADDRESS2 | COUNTRY | STATE       | CITY    | ZIPCODE | MOBILE_NUMBER |
      | Mr    | Abcd1234 | 31-October-1995 | YES               | YES                  | Satyajit   | Barman    | XYZ     | Prince Road |          | India   | West Bengal | Kolkata | 700032  | 9041533458    |
    And I click the button Create Account on the Signup page
    Then The below confirmation message should be displayed on the Signup page
      | ACCOUNT CREATED!                                                                                    |
      | Congratulations! Your new account has been successfully created!                                    |
      | You can now take advantage of member privileges to enhance your online shopping experience with us. |

  Scenario: Signup fails with existing email
    Given I am on the Login page
    When I enter the "Satyajit Barman" and "satyajitb9947@gmail.com" in the New User Signup on the Login page
    And I click the button Signup in the New User Signup on the Login page
    Then The below error message should be displayed just above the Signup button on the Login page
      | Email Address already exist! |