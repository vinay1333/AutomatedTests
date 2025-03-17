package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class QuestionnaireSuccess {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:5173/questionnaire");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }

    public void pageIsLoaded(String url) {
        driver.get(url);
    }

    public void selectAnswer(String questionNumber) {
        WebElement selectElement = wait.until(d -> d.findElement(By.tagName("select")));
        selectElement.click();
        WebElement option = wait.until(d -> d.findElement(By.xpath("//option[not(@value='')]")));
        option.click();
    }

    public void navigateThroughQuestions() {
        // Check if the 'Next' button is enabled, click until the last question
        while (true) {
            try {
                WebElement nextButton = wait.until(d -> d.findElement(By.xpath("//button[text()='Next']")));
                if (!nextButton.isEnabled()) {
                    break;
                }
                nextButton.click();
            } catch (Exception e) {
                break;
            }
        }
    }

    public void navigateBackThroughQuestions() {
        // Check if the 'Previous' button is enabled, click until the first question
        while (true) {
            try {
                WebElement previousButton = wait.until(d -> d.findElement(By.xpath("//button[text()='Previous']")));
                if (previousButton.isEnabled()) {
                    previousButton.click();
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }
    }

    public void checkBackButtonState() {
        WebElement previousButton = wait.until(d -> d.findElement(By.xpath("//button[text()='Previous']")));
        assertTrue("Back button should be disabled", !previousButton.isEnabled());
    }

    public void submitQuestionnaire() {
        WebElement submitButton = wait.until(d -> d.findElement(By.xpath("//button[text()='Submit']")));
        submitButton.click();
    }

    public void checkNavigation(String expectedUrl) {
        wait.until(d -> d.getCurrentUrl().equals(expectedUrl));
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}






