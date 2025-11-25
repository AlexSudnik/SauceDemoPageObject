package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {

    private static final By TITLE = By.xpath("//span[@data-test='title' and text()='Products']");
    private static final By CART_LINK = By.cssSelector(".shopping_cart_link");
    private static final By PRODUCTS_ON_INVENTORY_TITLES = By.cssSelector(".inventory_item_description");
    public static final By ADD_TO_CART_BUTTONS = By.cssSelector(".btn.btn_primary");
    public static final By ITEMS_PRICES = By.cssSelector(".inventory_item_price");
    public static final By ITEMS_NAMES = By.cssSelector(".inventory_item_name ");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public boolean inventoryPageIsOpen() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public void clickOnCartLink() {
        driver.findElement(CART_LINK).click();
    }

    public Integer getProductsOnInventoryNamesSize() {
        List<WebElement> productsOnInventoryPageTitles = driver.findElements(PRODUCTS_ON_INVENTORY_TITLES);
        return productsOnInventoryPageTitles.size();
    }

    public Integer getProductsOnInventoryPricesSize() {
        List<WebElement> productsOnInventoryPagePrices = driver.findElements(ITEMS_PRICES);
        return productsOnInventoryPagePrices.size();
    }

    public boolean cartButtonIsDisplayed() {
        return driver.findElement(By.cssSelector(".shopping_cart_link")).isDisplayed();
    }
}


