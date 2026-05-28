import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import lv.acodemy.page.*;


import lv.acodemy.utils.Constants;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


@Epic("Sauce demo test")
@Feature("Add item to the cart")
@Listeners(AllureTestNg.class)
public class SauceDemoTest {

    ChromeDriver driver;
    WebDriverWait wait;
    ChromeOptions options;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    HeaderPage headerPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    Constants constants;
    private static final Logger logger = LoggerFactory.getLogger(SauceDemoTest.class);

    Faker data = new Faker();
    FinishPage finishpage;

    @BeforeMethod
    public void beforeTest() {
        options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://saucedemo.com");


        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        headerPage= new HeaderPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        finishpage = new FinishPage(driver);

    }




    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that item was added to the cart")
    public void addItemToTheCart() {
        logger.info("User is trying to log in");


        loginPage.authorize("standard_user", "secret_sauce");
        Allure.step("User has logged in");

        Allure.step("Add item to the cart by name");
        inventoryPage.addItemToCartByName("Onesie");
        Assertions.assertThat(headerPage.getCarBadgeText()).isEqualTo("1");

        
        headerPage.getShoppingCartLink().click();
        Assertions.assertThat(cartPage.getCartItems().size()).isEqualTo(1);




        wait.until(ExpectedConditions.elementToBeClickable(cartPage.getCheckoutButton()));
        cartPage.getCheckoutButton().click();

        checkoutPage.fillCheckoutForm(data.name().firstName(), data.name().lastName(), data.address().zipCode());
        checkoutPage.getForSubmitButton().click();
        finishpage.getFinishButton().click();

        logger.info("Step 8: Verify success message");
        Assertions.assertThat(finishpage.getThankYouForYourOrder().getText()).isEqualTo(Constants.Messages.THANK_YOU_FOR_YOUR_ORDER);
        Assertions.assertThat(finishpage.getOtherTextCheck().getText()).isEqualTo(Constants.Messages.OTHER);
        finishpage.getBackToProducts().click();
        System.out.println("123");

    }


    @Test
    public void loginEmptyCredentialTest() {
        inventoryPage.getLoginButton().click();
        Assertions.assertThat(inventoryPage.getEpicSadFace().getText()).isEqualTo(Constants.Messages.EPIC);

    }




    @Test
    public void noPasswordIsGivenTest() {
        loginPage.getInputFieldUsername().sendKeys("Dima");
        loginPage.getInputFieldLogin().click();
        Assertions.assertThat(loginPage.getErrorMessageNoPassword().getText()).isEqualTo(Constants.Messages.NOPASSWORD);
    }


    @Test
    public void noUsernameTest() {
        loginPage.getInputFieldPassword().sendKeys("12345");
        loginPage.getInputFieldLogin().click();
        Assertions.assertThat(inventoryPage.getNoUsernameIsGiven().getText()).isEqualTo(Constants.Messages.NOUSERNAME);
    }


    @AfterMethod()
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}