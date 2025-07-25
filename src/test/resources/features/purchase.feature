Feature: Purchase flow

  Scenario: Add item to cart
    Given I am on the purchase page
    When I add an item to the cart
    Then the item should be added successfully

  Scenario: Check number of items in cart
    Given I have added an item to the cart
    When I view the cart
    Then I should see the correct number of items

  Scenario: Continue to purchase
    When I click on the cart
    Then I should proceed to checkout

  Scenario: Perform checkout
    When I click on the checkout button
    Then I should be on the checkout form

  Scenario: Fill in checkout form
    Given I have profile data from Excel
    When I fill the checkout form
    Then the form should be completed successfully

  Scenario: Finish purchase
    When I finish the purchase
    Then I should see a confirmation
