@Test
Feature: amazon cart
  As a user
  I want to add product in to cart
  so that i can verify price, subtotal in product page


  Background:
    Given user launch application

  Scenario Outline: Adding one Item in Cart and verifying sub total of product
    When  user Search the "<products>" and press enter
    And   user select the item in the list as per "<Position>" and clicking on Add to Cart
    And   user Open Cart from the top-left
    Then  Verify that the price is identical to the product page
    And   Verify that the sub total is identical to the product page

    Examples:
    |products|Position|
    |monitor|1      |
    |Laptop |2      |

  Scenario Outline:  Adding multiple Item in Cart and verifying sub total of product
    When  user Search the "<1products>" and press enter
    And   user select the item in the list as per "<Position>" and clicking on Add to Cart
    And   user Search the "<2products>" and press enter
    And   user select the item in the list as per "<Position>" and clicking on Add to Cart
    And   user Open Cart from the top-left
    Then  Verify that the price is identical to the product page
    And   Verify that the sub total is identical to the product page

    Examples:
      |1products  |Position|2products|
      |Headphones |1      |Keyboard   |
