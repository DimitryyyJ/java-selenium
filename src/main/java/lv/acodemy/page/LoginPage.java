package lv.acodemy.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final ChromeDriver driver;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "user-name")
    private WebElement inputFieldUsername;

    @FindBy(id="password")
    private WebElement inputFieldPassword;

    @FindBy(id="login-button")
    private WebElement inputFieldLogin;

    public WebElement getInputFieldUsername() {
        return inputFieldUsername;
    }

    public WebElement getInputFieldPassword() {
        return inputFieldPassword;
    }

    public WebElement getInputFieldLogin() {
        return inputFieldLogin;
    }

    @FindBy(className = "error-message-container")
    WebElement errorMessageNoPassword;

    public WebElement getErrorMessageNoPassword() {
        return errorMessageNoPassword;
    }

    public void authorize(String username, String password){
        inputFieldUsername.sendKeys(username);
        inputFieldPassword.sendKeys(password);
        inputFieldLogin.click();
    }

}
