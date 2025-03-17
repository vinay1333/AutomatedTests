package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class MovieResultSuccess {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:5173/movie-result");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void pageIsLoaded(String url) {
        driver.get(url);
    }

    public void waitForMovieDetailsAndLoadingScreen() {
        // Wait for loading screen to disappear
        wait.until(d -> d.findElement(By.id("loading-screen")).getAttribute("style").contains("display: none"));
    }

    public void checkMovieDetails() {
        // Locate movie details by tag or text within the paragraph tags
        wait.until(d -> d.findElement(By.xpath("//p[contains(text(), 'Title:')]")));
        wait.until(d -> d.findElement(By.xpath("//p[contains(text(), 'Genre:')]")));
        wait.until(d -> d.findElement(By.xpath("//p[contains(text(), 'Duration:')]")));
        wait.until(d -> d.findElement(By.xpath("//p[contains(text(), 'Rating:')]")));
        wait.until(d -> d.findElement(By.xpath("//p[contains(text(), 'Release Year:')]")));

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Title:')]")).isDisplayed(), "Movie title should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Genre:')]")).isDisplayed(), "Genre should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Duration:')]")).isDisplayed(), "Duration should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Rating:')]")).isDisplayed(), "Rating should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Release Year:')]")).isDisplayed(), "Release Year should be displayed");
    }

    public void checkResultButtons() {
        // Locate buttons by text and ensure they're visible
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Regenerate']")).isDisplayed(), "Regenerate");
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Start Again']")).isDisplayed(), "Start Again");
    }
}

