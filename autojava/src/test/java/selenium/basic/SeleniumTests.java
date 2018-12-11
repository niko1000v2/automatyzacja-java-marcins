package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeleniumTests {

    private WebDriver driver;

    @BeforeEach
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "c:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void canFindCodeSprintersOnGoogle() {


        driver.get("http://www.google.com/");
        WebElement seearchBox = driver.findElement(By.name("q"));
        seearchBox.sendKeys("code sprinters");
        seearchBox.submit();

        Stream<WebElement> searchResults = driver.findElements(By.cssSelector("div.rc")).stream();
        Stream<WebElement> resultFiltered = searchResults
                .filter(r -> r.findElement(By.cssSelector("div.r > a")).getAttribute("href")
                        .equals("http://agileszkolenia.pl/"));
        List<WebElement> resultsList = resultFiltered.collect(Collectors.toList());

        Assertions.assertEquals(1, resultsList.size());

        WebElement result = resultsList.get(0);
        Assertions.assertEquals("agileszkolenia.pl/", result.findElement(By.tagName("cite")).getText());

    }
    @AfterEach
    public void closeDriver(){
        driver.quit();
    }

}