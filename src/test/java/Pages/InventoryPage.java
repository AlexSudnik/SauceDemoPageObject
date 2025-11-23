package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory extends BasePage{

    private static final By TITLE = By.xpath("//span[@data-test='title' and text()='Products']");

    public Inventory(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }
    public boolean pageIsOpen(){
        return driver.findElement(TITLE).isDisplayed();

    }
}
