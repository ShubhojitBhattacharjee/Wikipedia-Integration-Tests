package net.wiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String searchText) {
        searchBox.sendKeys(searchText);
    }
}
