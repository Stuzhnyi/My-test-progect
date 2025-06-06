package homePageTestAllo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomePageTestAllo {
    @Test
    public void checkSearchButtonDisplay() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua");

        sleep(5000);

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search-form__input']"));
        searchInput.sendKeys("Фени");

        driver.findElement(By.xpath("//*[@id='__layout']/div/header/div[1]/div[2]/div[3]/form/button[2]")).click();

        sleep(3000);

        driver.findElement(By.partialLinkText("Фен")).click();

        sleep(3000);

        Assert.assertTrue(driver.getTitle().contains("Фен"), "Страница не содержит 'Фен' в заголовке");

        WebElement placeholderButton = driver.findElement(By.id("search-form__input"));
        Assert.assertTrue(placeholderButton.isDisplayed(), "Поле поиска не отображается");

        driver.quit();
    }
}
