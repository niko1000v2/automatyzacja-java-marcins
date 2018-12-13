package selenium.wordpresspageobjects.pages;

import org.openqa.selenium.WebDriver;

public class WpMainPage {
    private final WebDriver driver;

    public WpMainPage(WebDriver driver) {

        this.driver = driver;

    }

    public WpNotePage openLatestNote() {
        return new WpNotePage (driver);
    }
}
