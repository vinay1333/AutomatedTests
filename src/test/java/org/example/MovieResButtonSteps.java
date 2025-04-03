package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

    public class MovieResButtonSteps {

        @When("the user selects the Regenerate button")
        public void theUserSelectsTheRegenerateButton() {
            // Call the appropriate method from MovieResButtons class
        }

        @Then("a new movie is generated")
        public void aNewMovieIsGenerated() {
            // Placeholder method for the "Then" step
        }

        @And("the movie title should change")
        public void theMovieTitleShouldChange() {
            // Placeholder method for the "And" step
        }

        @And("the movie genre, duration, rating, and release year should be displayed")
        public void theMovieGenreDurationRatingAndReleaseYearShouldBeDisplayed() {
            // Placeholder method for the "And" step
        }

        // Scenario 2: User selects the "Start Again" button

        @When("the user selects the Start Again button")
        public void theUserSelectsTheStartAgainButton() {
            // Call the appropriate method from MovieResButtons class
        }
        @Then("the user should be redirected to the page {string}")
        public void theUserShouldBeRedirectedToThePage(String url) {
            // Placeholder method for the "Then" step
        }

        // Scenario 3: User selects the "Cast" button

        @When("the user selects the Show Cast button")
        public void theUserSelectsTheCastButton() {
            // Call the appropriate method from MovieResButtons class
        }

        @Then("the film's Cast List appears")
        public void theFilmsCastListAppears() {
            // Placeholder method for the "Then" step
        }

        @And("the button changes to Hide Cast")
        public void theButtonChangesToHideCast()  {
            // Placeholder method for the "And" step
        }

        @When("the user selects the Hide Cast button")
        public void theUserSelectsTheHideCastButton() {
            // Placeholder method for the "When" step
        }

        @Then("the film's Cast List disappears")
        public void theFilmsCastListDisappears() {
            // Placeholder method for the "Then" step
        }

        @And("the button returns to Show Cast")
        public void theButtonReturnsToShowCast() {
            // Placeholder method for the "And" step
        }
    }

