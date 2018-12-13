package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordpressTests {
    private WebDriver driver;


    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void addCommentOnBenedyktPage() {

        UUID uuid = UUID.randomUUID();
        String comment = uuid.randomUUID().toString();

        driver.get("https://automatyzacja.benedykt.net/");
        WebElement firstArticle = driver.findElement(By.cssSelector(".entry-title > a"));
        firstArticle.click();

        WebElement CommentField = driver.findElement(By.name("comment"));

        String tekstForCommentField = "Tekst tekstowy";
        CommentField.sendKeys(comment);

        WebElement AuthorField = driver.findElement(By.name("author"));

        String tekstForAuthorField = "Don Kichot";
        AuthorField.sendKeys(tekstForAuthorField);

        WebElement EmailField = driver.findElement(By.name("email"));

        String tekstForEmailFieldField = "donkichot@gmail.com";
        EmailField.sendKeys(tekstForEmailFieldField);

        WebElement PublicComment = driver.findElement(By.id("submit"));

        PublicComment.click();

        Stream<WebElement> listOfPostedComments = driver.findElements(By.cssSelector(".comment-list > .comment"))
                .stream();
        listOfPostedComments.filter(n -> n.findElement(By.cssSelector(".comment-content > p")).getText().equals(comment));

        Assertions.assertEquals(1, listOfPostedComments.count(), "Only one matching comment is found on page");
    }

    @AfterEach
    public void closeDriver() {

        driver.close();
    }


}