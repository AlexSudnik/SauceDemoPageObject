package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By CART_TITLE = By.xpath("//span[@data-test='title' and text()='Your Cart']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void authorizeSndGoToCartPage() {
        authorization();
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
    }

    public void cartPageIsOpen() {
        driver.findElement(CART_TITLE);
    }
}
