@APITest
Feature: Hepsiburada Petstore CRUD Tests


  Scenario: Add pet and check
    Given User on pet swagger api for "POST"
    When User created "cat" animal named "cavcav",tagged "miyav"
    Then HTTP status code should be 200
    And category,name and tag should be same what user created


  Scenario: Get last added pet and check
    Given User on pet swagger api for "GET"
    When User gets last added pet
    Then HTTP status code should be 200
    And category,name and tag should match with what user added


  Scenario: Update last added pet and check
    Given User on pet swagger api for "PUT"
    When User updates last added pet "dog","povpov","hav"
    Then HTTP status code should be 200
    And category,name and tag should be same what user updated


  Scenario: Delete last added pet and check
    Given User on pet swagger api for "DELETE"
    When User delete last added pet
    Then HTTP status code should be 200


  Scenario: Try get last deleted pet with id
    Given User on pet swagger api for "GET"
    When User try to get last deleted pet
    Then HTTP status code should be 404