package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class QSteps {

    @When("the user selects an option for question {string}")
    public void selectAnswer(String questionNumber) {
    }

    @When("the user navigates through all questions")
    public void navigateThroughQuestions() {
    }

    @When("the user submits the questionnaire")
    public void submitQuestionnaire() {
    }

}
