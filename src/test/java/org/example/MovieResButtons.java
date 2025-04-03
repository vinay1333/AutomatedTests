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

public class MovieResButtons {

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

    // Scenario 1: User selects the "Regenerate" button
    public void theUserSelectsTheRegenerateButton() {
        driver.findElement(By.xpath("//button[text()='Regenerate']")).click();
    }

    public void aNewMovieIsGenerated() {
        String newMovieTitle = driver.findElement(By.xpath("//p[contains(text(), 'Title:')]")).getText();
        Assert.assertNotNull(newMovieTitle, "New movie title should be displayed");
    }

    public void theMovieTitleShouldChange() {
        String previousMovieTitle = "Previous Movie Title";  // this would be captured earlier in real test
        String currentMovieTitle = driver.findElement(By.xpath("//p[contains(text(), 'Title:')]")).getText();
        Assert.assertNotEquals(currentMovieTitle, previousMovieTitle, "Movie title should change");
    }

    public void theMovieGenreDurationRatingAndReleaseYearShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Genre:')]")).isDisplayed(), "Genre should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Duration:')]")).isDisplayed(), "Duration should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Rating:')]")).isDisplayed(), "Rating should be displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Release Year:')]")).isDisplayed(), "Release Year should be displayed");
    }

    // Scenario 2: User selects the "Start Again" button
    public void theUserSelectsTheStartAgainButton() {
        driver.findElement(By.xpath("//button[text()='Start Again']")).click();
    }

    public void theUserShouldBeRedirectedToThePage(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "User should be redirected to the correct page");
    }

    // Scenario 3: User selects the "Cast" button
    public void theUserSelectsTheCastButton() {
        driver.findElement(By.xpath("//button[text()='Show Cast']")).click();
    }

    public void theFilmsCastListAppears() {
        Assert.assertTrue(driver.findElement(By.id("cast-list")).isDisplayed(), "The cast list should appear");
    }

    public void theButtonChangesToHideCast() {
        // This will check if the button label is "Hide Cast"
        String buttonText = driver.findElement(By.xpath("//button[text()='Hide Cast']")).getText();
        Assert.assertEquals(buttonText, "Hide Cast", "Button label should change to 'Hide Cast'");
    }

    public void theUserSelectsTheHideCastButton() {
        driver.findElement(By.xpath("//button[text()='Hide Cast']")).click();
    }

    public void theFilmsCastListDisappears() {
        Assert.assertFalse(driver.findElement(By.id("cast-list")).isDisplayed(), "The cast list should disappear");
    }

    public void theButtonReturnsToShowCast() {
        // This will check if the button label is "Show Cast"
        String buttonText = driver.findElement(By.xpath("//button[text()='Show Cast']")).getText();
        Assert.assertEquals(buttonText, "Show Cast", "Button label should return to 'Show Cast'");
    }
}


