package net.wiki.pages;

import org.openqa.selenium.WebDriver;


public class ArticlePage extends BasePage {



    public ArticlePage(WebDriver driver) {
        super(driver);

    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
