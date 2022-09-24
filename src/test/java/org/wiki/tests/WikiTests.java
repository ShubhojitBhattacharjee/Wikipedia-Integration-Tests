package org.wiki.tests;

import net.wiki.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class WikiTests extends BaseTest {

    @Test
    public void searchArticleTest() {

        String searchText = "Apollo 11";
        homePage = new HomePage(driver);

        homePage.searchFor(searchText);
        articlePage = homePage.selectAmongSearchResults(searchText);

        assertEquals(articlePage.getArticleHeading(), searchText);
    }
}
