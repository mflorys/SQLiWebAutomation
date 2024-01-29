package org.example.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePage {
    private final WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void closeConsentsPopup() {
        driver.findElement(By.id("L2AGLb")).click();
    }

    public void searchFor(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    public void clickOnWikipediaLink() {
        driver.findElement(By.cssSelector("a[href*='wiki']")).click();
    }
}
