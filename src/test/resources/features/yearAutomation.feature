# language: en
@ZaraTest
Feature: Automation of Wikipedia Search and Verification

  Background:
    Given the user is on the Google homepage
    When the user searches for the word "Automatización"

  @success
  Scenario: Verify the year of the first automatic process on Wikipedia
    Then the user clicks on the link related to Wikipedia
    And the user checks the information about the year of the first automatic process year "300 a. C"
    And the user takes a screenshot of the Wikipedia page

  @no_success
  Scenario: Verify the year of the first automatic process on Wikipedia, but year do not exists
    Then the user clicks on the link related to Wikipedia
    And the user checks the information about the year of the first automatic process year do not exists "400 a. C"

