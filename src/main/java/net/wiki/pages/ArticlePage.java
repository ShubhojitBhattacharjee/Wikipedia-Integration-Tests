package net.wiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ArticlePage extends BasePage {

    @FindBy(css = "h1#firstHeading")
    private WebElement heading;

    public ArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public String getArticleHeading() {
        waitForElementToBeClickable(heading);
        return heading.getText();
    }
}
