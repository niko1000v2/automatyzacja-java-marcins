package selenium.wordpresspageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WpMainPage {
    private final WebDriver driver;
    private static final String PAGE_URL = "https://automatyzacja.benedykt.net/";
    public static final By LATEST_COMMENT_SELECTOR = By.cssSelector(".entry-title > a");

    public WpMainPage(WebDriver driver) {

        this.driver = driver;
        this.driver.get(PAGE_URL);

    }

    public WpNotePage openLatestNote() {
        WebElement latestNotePageLink = driver.findElement(LATEST_COMMENT_SELECTOR);
        latestNotePageLink.click();

        return new WpNotePage (driver);
    }
}
