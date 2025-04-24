import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SauceDemoTest {


    ChromeDriver driver;

    @BeforeMethod
    public void beforeTest() {
        // Chromedriver;
        driver = new ChromeDriver();
        // URL: www.saucedemo.com
        driver.get("https://saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        // hello -> char sequence h e l l o;
        // By.id();
        // By.className();
        // By.xpath();
    }


    @Test
    public void verifyLoggedInTest() {
        String productsText = driver.findElement(By.className("title")).getText();
        assertThat(productsText)
                .withFailMessage("Expected title to be 'Products'")
                .isNotNull()
                .isNotEmpty()
                .startsWith("Prod")
                .endsWith("ucts")
                .isEqualTo("Products");

    }

    @AfterMethod()
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
