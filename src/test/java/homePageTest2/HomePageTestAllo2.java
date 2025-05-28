package homePageTest2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomePageTestAllo2 {

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

            try {
                WebElement element = driver.findElement(By.xpath("//*[@id='__layout']/div/header/div[1]/div[2]/a/img"));
                System.out.println("Елемент знайдено!");
            } catch (NoSuchElementException e) {
                System.out.println("Елемент не знайдено.");
            }


            driver.quit();

        }
}
