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

        sleep(5000); // Ожидание загрузки страницы

        WebElement searchInput = driver.findElement(By.id("search-form__input"));
        searchInput.sendKeys("Фен");
        searchInput.sendKeys(Keys.RETURN);

        sleep(3000); // Ожидание результатов поиска

        driver.findElement(By.partialLinkText("Фен")).click();

        sleep(3000); // Ожидание загрузки страницы товара

        Assert.assertTrue(driver.getTitle().contains("Фен"), "Страница не содержит 'Фен' в заголовке");

        WebElement placeholderButton = driver.findElement(By.id("search-form__input"));
        Assert.assertTrue(placeholderButton.isDisplayed(), "Поле поиска не отображается");

        driver.quit();
    }
}