Feature: Movie Result

  Scenario: User views the movie result after submitting the questionnaire
    Given the page "http://localhost:5173/movie-result" is loaded
    When the user waits for movie details to load
    Then the movie title, genre, duration, rating, and release year should be displayed
    Then the 'Regenerate' and 'Start Again' buttons should be visible
