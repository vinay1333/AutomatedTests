Feature: Questionnaire

  Scenario: User completes the questionnaire
    Given the page "http://localhost:5173/questionnaire" is loaded
    When the user selects an option for question "1"
    And the user navigates through all questions
    And the user submits the questionnaire
    Then the page should be "http://localhost:5173/movie-result"
