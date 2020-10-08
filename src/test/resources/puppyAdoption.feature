Feature: Puppy adoption

  As puppy site user
  I want to adopt puppies from puppy list

  Scenario: As puppy site user I want to adopt one puppy from puppy list
    Given I have navigated to Home Page
    When I select Brook
    And I add Brook to cart
    And I complete the adoption
    And I place order with "Check"
    Then I should see an adoption confirmation message


