Feature: Place an Order
  As a registered user
  I want to place an order on the ecommerce site
  So that I can complete a purchase successfully

  Scenario: Successful order placement
    Given I landed on Ecommerce Page
    And Logged in with username arjunmal@gmail.com and password Eagle@eye1
    When I add product ZARA COAT 3 to Cart
    And Checkout ZARA COAT 3 and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

  Scenario: Login failure with wrong password
    Given I landed on Ecommerce Page
    And Logged in with username arjunmalhotra@gmail.com and password WrongPass
    Then "Incorrect email or password." message is displayed
