package net.wiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchBox;

    /**
     * Constructor
     * @param driver initialized in BaseTest and passed from TestNG method
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.get("https://www.wikipedia.org/");
    }

    /**
     * Enter search string
     * @param searchText: search string
     */
    public void searchFor(String searchText) {
        searchBox.sendKeys(searchText);
    }

    /**
     * Select from the drop-down list the string matching the searchText
     * Selecting this result navigates user to the next page, when success
     * @param searchText: search string
     * @return instance of ArticlePage
     */
    public ArticlePage selectAmongSearchResults(String searchText) {
        String cssPath = "div.suggestions-dropdown>a h3";
        retryGetElementTextAndClick(By.cssSelector(cssPath), searchText);
        return new ArticlePage(driver);
    }
}
