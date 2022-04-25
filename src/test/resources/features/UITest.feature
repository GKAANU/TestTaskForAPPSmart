Feature: American Burger & Pizza House Augsburg UI Test

  @test01 @UItest
  Scenario: Shopping cart subtotal should match user added items
    Given User navigates to the "ui_url" website
    When User clicks "Burger" category
    And User adds "Cheeseburger"
    And User select "86153 - Augsburg (Innenstadt)"
    And User clicks "Confirm" in extra order popup
    And User clicks 3 times "plus" in "Cheeseburger"
    Then User added item total and shopping cart subtotal should match

  @test02 @UItest
  Scenario: Add food on shopping cart and delete then check
    Given User navigates to the "ui_url" website
    When User clicks "Angebote" category
    And User adds "Sparmenü 2"
    And User select "86153 - Augsburg (Innenstadt)"
    And User adds "Sparmenü 2"
    And User selects "Big Mexican Burger" and clicks "Next step" button
    And User adds "Pommes + Coca Cola" and clicks "Next step"
    And User selects "Hot American Burger" and clicks "Next step" button
    And User adds "Pommes + Cola light" and clicks "Next step"
    And User selects "Helles Bier" and clicks  "Next step"
    And User selects "Helles Weizen" and clicks  "Next step"
    And User deletes "Sparmenü 2" on shopping cart
    Then User should see "Your shopping cart is empty" message on shopping cart
