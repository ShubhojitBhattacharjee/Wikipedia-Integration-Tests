package net.wiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchBox;

    @FindBy(css = "div.suggestions-dropdown>a")
    private WebElement suggestionsList;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.get("https://www.wikipedia.org/");
    }

    public void searchFor(String searchText) {
        searchBox.sendKeys(searchText);
    }

    public ArticlePage selectAmongSearchResults(String searchText) {
        waitForElementToBeVisible(suggestionsList);
        if (suggestionsList.findElement(By.tagName("h3")).getText().equalsIgnoreCase(searchText)) {
            suggestionsList.click();
            return new ArticlePage(driver);
        }
        return null;
    }
}
