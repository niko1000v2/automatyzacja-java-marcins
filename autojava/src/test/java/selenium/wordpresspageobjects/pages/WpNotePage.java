package selenium.wordpresspageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WpNotePage {
    public static final By COMMENT_FIELD = By.name("comment");
    public static final By AUTHOR_FIELD = By.name("author");
    public static final By EMAIL_FIELD = By.name("email");
    public static final By SUBMIT_BUTTON = By.id("submit");

    private final WebDriver driver;

    public WpNotePage(WebDriver driver) {
        this.driver = driver;

        //here you open new wordpresspage

    }

    public WpNotePage addComment(String comment, String author, String email) {
        // here you finde and open lates note (first note)
        WebElement commentField = driver.findElement(COMMENT_FIELD);
        commentField.sendKeys(comment);

        WebElement authorField = driver.findElement(AUTHOR_FIELD);
        authorField.sendKeys(author);

        WebElement emailField = driver.findElement(EMAIL_FIELD);
        emailField.sendKeys(email);

        WebElement submitButton = driver.findElement(SUBMIT_BUTTON);
        submitButton.click();

        return new WpNotePage(driver);

    }

    public boolean commentExists(String comment, String author) {

        Stream<WebElement> comments = driver.findElements(By.cssSelector(".comment-list > .comment"))
                .stream()
                .filter(c -> c.findElement(By.cssSelector(".comment-author > b")).getText().equals(author))
                .filter(c -> c.findElement(By.cssSelector(".comment-content > p")).getText().equals(comment));

        List<WebElement> collectList = comments.collect(Collectors.toList());


       /* return collectList.size()==1; to to samo co poniższy if:
              if (collectList.size()==1) {
            return true;
        }
        return false;*/



        return collectList.size()==1;
    }
}
