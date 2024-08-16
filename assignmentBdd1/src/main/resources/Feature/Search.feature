@Search
Feature: Search

  Background:
    Given the user opens the automationteststore website
    And the user clicks on the "Login or register" button
    And the user logs in using username "mohamed" and password "mohamed"
    And the user clicks on the home button

  Scenario: Verify searching for a product that exists in the website (in stock)
    Given the user inserts a product name "Skinsheen Bronzer Stick"
    When  the user press Enter
    Then  the searched product "Skinsheen Bronzer Stick" appears correctly

  Scenario: Verify searching for a product that does not exist in the website
    Given the user inserts a product name "mohamed Elattar"
    When  the user press Enter
    Then the message "There is no product that matches the search criteria." is displayed


  Scenario: Verify searching for a product using partial name
    Given the user inserts a product name "Skinsheen"
    When  the user press Enter
    Then the searched product "Skinsheen Bronzer Stick" appears correctly

  Scenario: Verify searching for an out-of-stock product
    Given the user inserts a product name "BeneFit Girl Meets Pearl"
    When  the user press Enter
    Then  the searched product "BeneFit Girl Meets Pearl" appears correctly
    And the product should have a notice that it is out of stock

