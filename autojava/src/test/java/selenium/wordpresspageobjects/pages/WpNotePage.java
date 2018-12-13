package selenium.wordpresspageobjects.pages;

import org.openqa.selenium.WebDriver;

public class WpNotePage {
    private final WebDriver driver;

    public WpNotePage(WebDriver driver) {
        this.driver = driver;

        //here you open new wordpresspage

    }

    public WpNotePage addComment(String comment, String author, String email) {
        // here you finde and open lates note (first note)
        return new WpNotePage(driver);

    }

    public boolean commentExists(String comment, String author) {
        return false;
    }
}
