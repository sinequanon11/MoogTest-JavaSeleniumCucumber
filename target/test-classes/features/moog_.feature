@runAll
Feature: Testing the Moog web page

  Background:
    When Go to Moog home page
    And accept all cookies

  @moog1
  Scenario: TC_1 Searching an item that is not available on the web page
    When Clicking the Search button
    And Entering <"item1"> in the Search bar
    And Clicking the Search item button
    Then Asserting that this item is not available on the web page

  @moog2
  Scenario: TC_2 Searching an item that is available on the web page
    When Clicking the Search button
    And Entering the <"item2"> in the Search bar
    And Clicking the Search item button
    Then Asserting that this item is available on the web page

  @moog3
  Scenario: TC_3 Searching an item from an Excel file and asserting that the search result is greater than 100
    When Clicking the Search button
    And Entering the item from the "Moog" sheet in the Excel file into the Search bar
    And Clicking the Search item button
    Then Asserting that the search result is greater than <"100">

    @moog4
  Scenario: TC_4 Searching an item and asserting that the expected and actual number of search results are the same
    When Clicking the Search button
    And Entering the item <"item3"> in the Search bar
    And Clicking the Search item button
    Then Asserting that the number of search results of <"item3"> is the same of the actual search results

  @moog5
  Scenario Outline: TC_5 Testing Contact Us - Negative Scenario
    When Clicking Contact Us
    And Clicking Find an Industry Solution Contact Us and Construction
    Then Asserting that we are on the Construction page
    And Entering full name "<name>"
    And Entering invalid "<email>"
    And Selecting a product
    And Entering Message
    And Clicking to Agree that Customer can be contacted by Email and Phone
    And Submitting the form
    Then Submission is not successful

    Examples:
      | name        | email      |
      | James Young | ssss       |
      | Jon Smith   | ssss@      |
      | Kim Walt    | ssss@gmail |
