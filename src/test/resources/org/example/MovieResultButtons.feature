Feature: Movie Result Buttons

  Scenario: User selects the regenerate button
    Given the page "http://localhost:5173/movie-result" is loaded
    When the user selects the Regenerate button
    Then a new movie is generated
    And the movie title should change
    And the movie genre, duration, rating, and release year should be displayed

  Scenario: User selects the Start Again button
    Given the page "http://localhost:5173/movie-result" is loaded
    When the user selects the Start Again button
    Then the user should be redirected to the page "http://localhost:5173/welcome-screen"

  Scenario: User selects the Cast button
    Given the page "http://localhost:5173/movie-result" is loaded
    When the user selects the Show Cast button
    Then the film's Cast List appears
    And the button changes to Hide Cast
    When the user selects the Hide Cast button
    Then the film's Cast List disappears
    And the button returns to Show Cast
