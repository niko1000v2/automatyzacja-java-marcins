package selenium.wordpresspageobjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.wordpresspageobjects.pages.WpMainPage;
import selenium.wordpresspageobjects.pages.WpNotePage;

import java.util.UUID;

public class WordPressTests extends BaseTest {

    @Test
    public void canAddCommentToFirstNote() {

        String comment = generateRandomText();
        String author = generateRandomText();
        String email = generateRandomEmail();
        //open wordpressMainPage
        WpMainPage mainPage = new WpMainPage(driver);

        //open first note
        WpNotePage latestNote = mainPage.openLatestNote();

        //add comment
        WpNotePage latestNoteWithComment = latestNote.addComment(comment, author, email):

        //check that comment is added
        Assertions.assertTrue(latestNoteWithComment.commentExists(comment, author));

    }

    private String generateRandomEmail() {
        return generateRandomText() + "@itcrowd.com";
    }

    private String generateRandomText() {
        return UUID.randomUUID().toString();
    }
}

