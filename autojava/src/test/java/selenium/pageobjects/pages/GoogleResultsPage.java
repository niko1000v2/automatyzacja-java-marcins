package selenium.pageobjects.pages;

import org.openqa.selenium.WebDriver;

public class GoogleResultsPage {
    private final WebDriver driverGrp;

    public GoogleResultsPage(WebDriver driver) {
        driverGrp = driver;
    }

    public boolean contains(String pageUrl) {
        return false;
    }
}
