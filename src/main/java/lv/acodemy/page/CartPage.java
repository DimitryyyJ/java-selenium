package lv.acodemy.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public CartPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cart_item")
    List<WebElement> cartItems;

    public List<WebElement> getCartItems() {
        return cartItems;
    }

    @FindBy(id="checkout")
    private WebElement checkoutButton;

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }


}
