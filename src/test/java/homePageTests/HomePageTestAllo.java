package homePageTests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageTestAllo {



    public static class AlloSearchTest {

        private WebDriver driver;

        @Before
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void testAirPods3Search() throws InterruptedException {

            driver.get("https://allo.ua/");


            WebElement alloLogo = driver.findElement(By.cssSelector("a.header__logo"));
            assertTrue("Лого не відображається", alloLogo.isDisplayed());

            sleep(10000);

            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.sendKeys("AirPods 3");

            WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
            searchButton.click();

            WebElement firstProductTitle = driver.findElement(By.cssSelector(".product-card__title"));
            String productNameOnList = firstProductTitle.getText();
            assertTrue("У назві першого товару немає 'AirPods 3'", productNameOnList.contains("AirPods 3"));

            String savedProductName = productNameOnList;

            firstProductTitle.click();

            // 8. Перевірити, що назва товару на новій сторінці відповідає попередній
            WebElement productTitleOnPage = driver.findElement(By.cssSelector("h1.product__title"));
            String detailedProductName = productTitleOnPage.getText();
            assertEquals("Назва товару на сторінці не відповідає тій, що була в списку", savedProductName, detailedProductName);
        }

        @After
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}
