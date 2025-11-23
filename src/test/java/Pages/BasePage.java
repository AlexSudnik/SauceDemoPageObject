package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    protected final String BASE_URL = "https://www.saucedemo.com/";
    protected final By LOGIN_INPUT = By.id("user-name");
    protected final By PASSWORD_INPUT = By.id("password");
    protected final By LOGIN_BUTTON = By.id("login-button");


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void authorization() {
        driver.get(BASE_URL);
        driver.findElement(LOGIN_INPUT).clear();
        driver.findElement(LOGIN_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).clear();
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
    }
}
