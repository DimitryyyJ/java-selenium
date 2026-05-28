package lv.acodemy.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
    public  FinishPage(ChromeDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    public WebElement getFinishButton() {
        return finishButton;
    }

    @FindBy(id="back-to-products")
    private WebElement backToProducts;

    public WebElement getBackToProducts() {
        return backToProducts;
    }

    @FindBy(xpath="//h2[@data-test='complete-header']")
    private WebElement thankYouForYourOrder;

    public WebElement getThankYouForYourOrder() {
        return thankYouForYourOrder;
    }

    @FindBy(xpath="//div[@data-test='complete-text']")
    private WebElement otherTextCheck;

    public WebElement getOtherTextCheck() {
        return otherTextCheck;
    }
}
