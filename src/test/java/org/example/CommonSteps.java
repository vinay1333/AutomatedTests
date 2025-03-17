package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps {

    private Welcome welcome;
    private QuestionnaireSuccess questionnaire;

    // Shared step definition for loading a page
    @Given("the page {string} is loaded")
    public void pageIsLoaded(String url) {
        }

    // Shared step definition for checking navigation
    @Then("the page should be {string}")
    public void checkNavigation(String expectedUrl) {
    }

}



