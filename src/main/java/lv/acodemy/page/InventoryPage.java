package lv.acodemy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {


    @FindBy(id="login-button")
    private WebElement loginButton;

    public WebElement getLoginButton() {
        return loginButton;
    }

    @FindBy(className = "error-message-container")
    private WebElement epicSadFace;

    public WebElement getEpicSadFace() {
        return epicSadFace;
    }


    @FindBy(className = "error-message-container")
    private WebElement noUsernameIsGiven;

    public WebElement getNoUsernameIsGiven() {
        return noUsernameIsGiven;
    }

    public InventoryPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
    List<WebElement> inventoryItems;

    private final By addToCartButton = By.xpath(".//button[contains(@class,'btn_inventory')]");

    public void addItemToCartByName(String itemName) {
        for (WebElement item : inventoryItems) {
            if(item.getText().contains(itemName)) {
                item.findElement(addToCartButton).click();
                break;
            }
        }
    }
}