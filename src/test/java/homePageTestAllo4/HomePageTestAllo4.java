package homePageTestAllo4;

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

public class HomePageTestAllo4 {

    @Test
    public void checkSearchButtonDisplay() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://allo.ua");

        sleep(5000);

        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='__layout']/div/header/div[1]/div[1]/div[2]/div/a")));
        Assert.assertTrue(logo.isDisplayed(), "Кнопка Покупцям не відображається");

        driver.findElement(By.xpath("//*[@id='__layout']/div/header/div[1]/div[1]/div[2]/div/a")).click();

        sleep(3000);

        WebElement dropDownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='__layout']/div/header/div[1]/div[1]/div[2]/div/div/a[1]")));
        Assert.assertTrue(dropDownMenu.isDisplayed(), "Кнопка Доставка і оплата не відображається");

        driver.findElement(By.xpath("//*[@id='__layout']/div/header/div[1]/div[1]/div[2]/div/div/a[1]")).click();

        sleep(3000);

            String pageTitle = driver.getTitle();
            Assert.assertTrue(pageTitle.contains("Доставка і оплата"),
                    "Заголовок сторінки не містить текст 'Доставка і оплата'. Поточний title: " + pageTitle);

        sleep(3000);

        WebElement questionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Як оформити замовлення?']")));

        // Перевіряємо, що елемент видимий
        Assert.assertTrue(questionElement.isDisplayed(), "Елемент 'Як оформити замовлення?' не відображається");

        // Перевіряємо, що текст повністю відповідає очікуваному
        String actualText = questionElement.getText().trim();
        Assert.assertEquals(actualText, "Як оформити замовлення?", "Текст елемента не збігається з очікуваним");


        driver.quit();
    }
}

