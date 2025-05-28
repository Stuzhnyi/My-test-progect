package homePageTestAllo3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class HomePageTestAllo3 {
    @Test
    public void checkSearchButtonDisplay() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://allo.ua");

        sleep(5000);

        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='__layout']/div/header/div[1]/div[2]/a/img")));
        Assert.assertTrue(logo.isDisplayed(), "Логотип ALLO не відображається");

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search-form__input']"));
        searchInput.sendKeys("AirPods 3");

        driver.findElement(By.xpath("//*[@id='__layout']/div/header/div[1]/div[2]/div[3]/form/button[2]")).click();

        sleep(3000);

        driver.findElement(By.partialLinkText("AirPods 3")).click();

        sleep(3000);

        Assert.assertTrue(driver.getTitle().contains("AirPods 3"), "Страница не содержит 'Фен' в заголовке");

        WebElement placeholderButton = driver.findElement(By.id("search-form__input"));
        Assert.assertTrue(placeholderButton.isDisplayed(), "Поле поиска не отображается");

        driver.quit();
    }
}
