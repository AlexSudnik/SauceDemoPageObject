package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    private static final By ERROR_MESSAGE = By.xpath("//h3[@data-test = 'error']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void inputLogin(String userName) {
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
    }

    public void inputPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }


}

