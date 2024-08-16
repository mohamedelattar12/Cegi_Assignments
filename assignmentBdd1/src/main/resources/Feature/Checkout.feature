@Checkout
Feature: Checkout
  Background:
    Given the user opens the automationteststore website
    And the user clicks on the "Login or register" button
    And the user logs in using username "mohamed" and password "mohamed"
    And the user clicks on the home button

  Scenario: Verify checkout of a valid product in stock
    Given the user clicks on a product name "Skinsheen Bronzer Stick" which is in stock
    And the user clicks the "add to cart" button
    And the user clicks the "Checkout" button
    When the user clicks the "Confirm order" button
    Then the message "Your Order Has Been Processed!" appears after the purchase

  Scenario: Verify checkout of 10 products in stock
    Given the user clicks on a product name "Skinsheen Bronzer Stick" which is in stock
    And the user increases the quantity to "10"
    And the user clicks the "add to cart" button
    And the user clicks the "Checkout" button
    When the user clicks the "Confirm order" button
    Then the message "Your Order Has Been Processed!" appears after the purchase

  Scenario: Verify that the system refuses checkout with an empty cart
    When the user clicks the "Checkout" button at homepage
    Then the error message "Your shopping cart is empty!" appears

  Scenario: Verify that out-of-stock items prevent checkout completion
    When the user clicks on a product name "BeneFit Girl Meets Pearl" which is out of stock
    Then the "add to cart" button should be disabled