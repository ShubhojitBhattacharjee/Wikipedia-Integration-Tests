package org.wiki.tests;

import net.wiki.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class WikiTests extends BaseTest {


    @Test(dataProvider = "Search Article")
    public void searchArticleTest(String searchText) {

//        String searchText = "Apollo 11";
        reportLog("Launch Wikipedia Page");
        homePage = new HomePage(driver);

        reportLog("Search for " + searchText);
        homePage.searchFor(searchText);

        reportLog("Select among search results");
        articlePage = homePage.selectAmongSearchResults(searchText);

        reportLog("Verify article for \"" + searchText + "\" loaded");
        assertEquals(articlePage.getArticleHeading(), searchText);
    }
}
