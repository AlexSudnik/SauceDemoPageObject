package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private static final By TITLE = By.xpath("//span[@data-test='title' and text()='Products']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public void authorizeAndGoToInventaryPage() {
        authorization();
    }

    public boolean inventoryPageIsOpen() {
        return driver.findElement(TITLE).isDisplayed();

    }

    public void putProductInCart() {
        authorizeAndGoToInventaryPage();
        driver.findElement(By.cssSelector(".btn_small.btn_inventory")).click();
    }
}
