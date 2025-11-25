package Tests;

import Pages.CartPage;
import Pages.InventoryPage;
import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BaseTest {

    WebDriver driver;
    SignInPage signInPage;
    InventoryPage inventoryPage;
    CartPage cartpage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--headless");
        options.addArguments("--incognito");
        //options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));

        signInPage = new SignInPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartpage = new CartPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}