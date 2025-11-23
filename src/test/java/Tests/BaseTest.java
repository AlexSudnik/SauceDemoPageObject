package Tests;

import Pages.BasePage;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.SignInPage;
import org.openqa.selenium.By;
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
    BasePage basePage;
    CartPage cartpage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--incognito");
        //options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));

        basePage = new BasePage(driver);
        signInPage = new SignInPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartpage = new CartPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}