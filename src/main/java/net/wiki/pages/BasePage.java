package net.wiki.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        wait.until( ExpectedConditions.elementToBeClickable(element));
    }

    public void retryGetElementTextAndClick(By by, String text) {
        int attempts = 1;
        while(attempts++ <= 15) {
            try {
                if (driver.findElement(by).getText().equals(text)) {
                    driver.findElement(by).click();
                    break;
                }
            } catch(StaleElementReferenceException e) {
                System.out.println("Attempt = " + attempts + " to find " + text + " failed");
            } catch (WebDriverException e) {
                System.out.println("Attempt in WebDriverException catch = " + attempts);
            }
        }
    }
}
