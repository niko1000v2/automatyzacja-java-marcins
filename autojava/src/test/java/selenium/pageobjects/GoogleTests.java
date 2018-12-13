package selenium.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageobjects.pages.GoogleMainPage;
import selenium.pageobjects.pages.GoogleResultsPage;

public class GoogleTests extends BaseTest {


    @Test
    public void canFindSteamOnGooglePage(){

        String pageUrl = "https://store.steampowered.com/";

        //Open google page
        GoogleMainPage googlePage = new GoogleMainPage(driver);

        //Search for "Steam" on GooglePage
        GoogleResultsPage googleResults = googlePage.search("Steam");

        //Assert  search result

        Assertions.assertTrue(googleResults.contains(pageUrl));
    }

}
