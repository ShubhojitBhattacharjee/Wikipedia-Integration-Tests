package org.wiki.tests;

import net.wiki.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class WikiTests extends BaseTest {

    @Test
    public void searchArticleTest() {

        String searchText = "Apollo 11";
        reportLog("Launch Wikipedia Page");
        homePage = new HomePage(driver);

        reportLog("Search for " + searchText);
        homePage.searchFor(searchText);

        reportLog("Select among search results");
        articlePage = homePage.selectAmongSearchResults(searchText);

        reportLog("Verify correct article page opened");
        assertEquals(articlePage.getArticleHeading(), searchText);
    }
}
