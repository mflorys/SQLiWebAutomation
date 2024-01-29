package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.model.GoogleSearchPage;
import org.example.model.WikipediaPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WikipediaPageTests {

    WebDriver driver = new ChromeDriver();
    GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
    WikipediaPage wikipediaPage = new WikipediaPage(driver);

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void shouldFirstAutmationTestHappenin2017() throws IOException {
        driver.get("https://google.com");
        googleSearchPage.closeConsentsPopup();
        googleSearchPage.searchFor("automation");
        googleSearchPage.clickOnWikipediaLink();

        WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'the first version of')]"));
        wikipediaPage.scrollToElement(element);
        wikipediaPage.takeScreenshot(driver);

        String year = wikipediaPage.getFirstAutomaticProcessYear();
        Assertions.assertEquals("2017", year);
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
