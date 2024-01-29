package org.example.model;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikipediaPage extends BasePage{
    private final WebDriver driver;

    public WikipediaPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstAutomaticProcessYear() {
        WebElement firstAutoElement = driver.findElement(By.xpath("//*[contains(text(), 'the first version of')]"));
        String firstAutoString = firstAutoElement.getText();
        String yearPattern = "(\\d{4})";
        Pattern pattern = Pattern.compile(yearPattern);
        Matcher matcher = pattern.matcher(firstAutoString);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "No matching string found!";
        }
    }

    public void takeScreenshot(WebDriver driver) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
    }

}
