package org.example;

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

public class Welcome {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        final var options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:5173/");

        // Initialize WebDriverWait once
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }

    // This method is called by the WelcomeSteps class
    public void pageIsLoaded(String url) {
        driver.get(url);
    }

    // This method is called by the WelcomeSteps class
    public void clickStartButton(String buttonId) {
        // Use the shared WebDriverWait to find and click the button
        WebElement button = wait.until(d -> d.findElement(By.className(buttonId)));
        button.click();
    }

    // This method is called by the WelcomeSteps class
    public void checkNavigation(String expectedUrl) {
        // Wait for the URL to match the expected URL
        wait.until(d -> d.getCurrentUrl().equals(expectedUrl));

        // Assert the page URL
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}


