package net.wiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        wait.until( ExpectedConditions.elementToBeClickable(element));
    }
}
