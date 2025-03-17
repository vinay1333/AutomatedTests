Feature: Welcome

  Scenario: The user clicks the start button
    Given the page "http://localhost:5173/" is loaded
    When the user selects the "start-button" button
    Then the page should be "http://localhost:5173/questionnaire"

