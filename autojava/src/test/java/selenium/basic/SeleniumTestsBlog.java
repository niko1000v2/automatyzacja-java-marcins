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
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeleniumTestsBlog {

    // This field (variable named 'driver') must be declared on class level (not inside any method) so that it can be shared across all methods
    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
     //   System.setProperty("webdriver.chrome.driver", "c:\\WebDrivers\\chromedriver.exe");
        // jeśli nie ustawiono zmiennych systemowych to powyższa linijka będzie potrzebna do uruchomienia chromedrivera
        //oczywiście z odpowiednią lokalizacją pliku
        driver = new ChromeDriver();

        //maksymalizacja okna przeglądarki
        driver.manage().window().maximize();

        // czas czekania między poszczególnymi operacjamia drivera
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void verifyAuthorOfBlogNoteAboutTransformations() {
        driver.get("http://markowicz.pro");
        Stream<WebElement> listOfNotes = driver.findElements(By.className("entry-title"))
                .stream().filter(n -> n.findElement(By.tagName("a")).getText().equals("O transformacjach"));
        List<WebElement> filteredNotes = listOfNotes.collect(Collectors.toList());

        Assertions.assertEquals(1, filteredNotes.size(), "Only one matching note is found on main page");

        driver.findElement(By.cssSelector("#eu-cookie-law input")).submit();

        //kliknięcie na znalezionym elemencie
        filteredNotes.get(0).click();

        WebElement author = driver.findElement(By.cssSelector(".author > a"));
        Assertions.assertEquals("Rafał", author.getText(),"Proper author name is displayed");
        Assertions. assertEquals("http://markowicz.pro/author/rafal-markowicz/",
                author.getAttribute("href"), "Valid author URL is displayed");

    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}