package homePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomePageTest {

    @Test
    public void checkMansButtonDisplay() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.thenorthface.com");

        WebElement mansButtonLocator = driver.findElement(By.xpath("//a[@id='mega-menu-l1-2073348']"));

        Assert.assertTrue(mansButtonLocator.isDisplayed());

    }

    @Test
    public void checkMansPageOpened() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://epicentrk.ua/");

        sleep(5000);

        WebElement catalogButton = driver.findElement(By.xpath("//*[@id='global-site-header']/header/div/div[1]/div/div[2]"));

        catalogButton.isDisplayed();

        catalogButton.click();

        sleep(2000);



        driver.quit();

    }


}
