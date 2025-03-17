package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WelcomeSuccess {

    private WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        final var options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:5173/");
    }

    @Test
    public void testWelcomeText() {

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the welcome-screen element to be displayed using lambda expression
        wait.until(d -> d.findElement(By.className("welcome-screen")).isDisplayed());

        final var welcome = driver.findElement(By.className("welcome-screen"));
        String message = "Welcome to Movie Guru\n" +
                "Answer a few questions to get a movie recommendation!\n" +
                "Get Started";

        assertEquals(message, welcome.getText());
    }

    @Test
    public void testButtonClick() {

        // Wait for the button to be clickable
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(d -> d.findElement(By.className("start-button")));

        // Click the button
        button.click();

        // After clicking the button, verify if the expected result happens
        // Example: check if a new element appears, or page redirects, etc.
        WebElement someElement = wait.until(d -> d.findElement(By.className("questionnaire")));

        // Verify if the element is displayed, meaning the button click triggered the change
        assertTrue(someElement.isDisplayed());
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }
}

