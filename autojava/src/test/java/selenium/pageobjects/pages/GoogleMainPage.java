package selenium.pageobjects.pages;

import org.openqa.selenium.WebDriver;

public class GoogleMainPage {
    private final WebDriver driverGmp;

    public GoogleMainPage(WebDriver driver) {
        driverGmp = driver;
        driverGmp.get("http://www.google.com");
    }

    public GoogleResultsPage search(String searchQuerry) {
        return new GoogleResultsPage(driverGmp);
    }
}
