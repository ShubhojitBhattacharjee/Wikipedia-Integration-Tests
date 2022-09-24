package org.wiki.tests;

import net.wiki.pages.HomePage;
import org.testng.annotations.Test;

public class WikiTests extends BaseTest {

    @Test
    public void searchArticleTest() {

        String searchText = "Apollo 11";
        homePage = new HomePage(driver);

        homePage.searchFor(searchText);
    }
}
