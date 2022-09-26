package org.wiki.tests;

import net.wiki.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 * TestNG Class to Verify Search on Wikipedia
 */
public class WikiTests extends BaseTest {


    /**
     * End-to-end test to verify Wikipedia search
     * @param searchText from DataProvider method defined in parent class - BaseTest
     */
    @Test(dataProvider = "Search Article")
    public void searchArticleTest(String searchText) {

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
