package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By CART_TITLE = By.xpath("//span[@data-test='title' and text()='Your Cart']");
    private static final String CART_URL = "https://www.saucedemo.com/cart.html";
    private static final By CHECKOUT_BUTTON = By.xpath("//span[@data-test='title' and text()='Your Cart']");
    private static final By CONTINUE_SHOPPING_BUTTON = By.xpath
            ("//button[@data-test='continue-shopping' and text()='Continue Shopping']");
    public static final By CART_LINK = By.cssSelector(".shopping_cart_link");
    public final By addedToCartItemPrice = By.xpath("//div[@class='inventory_item_price']");
    public final By cartItemName = By.xpath("//div[@class='inventory_item_name']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(CART_URL);
    }

    public boolean cartPageIsOpen() {
        return driver.findElement(CART_TITLE).isDisplayed();
    }

    public boolean isCheckoutButtonDisplayed() {
        return driver.findElement(CHECKOUT_BUTTON).isDisplayed();
    }

    public boolean isContinueShoppingButtonDisplayed() {
        return driver.findElement(CONTINUE_SHOPPING_BUTTON).isDisplayed();
    }

    public void clickOnCartLink() {
        driver.findElement(CART_LINK).click();
    }
}
