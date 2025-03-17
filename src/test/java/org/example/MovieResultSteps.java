package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class MovieResultSteps {

    @When("the user waits for movie details to load")
    public void waitForMovieDetailsAndLoadingScreen() {
    }

    @Then("the movie title, genre, duration, rating, and release year should be displayed")
    public void checkMovieDetails() {
    }

    @Then("the 'Regenerate' and 'Start Again' buttons should be visible")
    public void checkResultButtons() {
    }
}


