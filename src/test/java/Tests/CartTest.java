package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    void burgerMenuIsDisplayed() {
        cartpage.authorizeSndGoToCartPage();
        cartpage.cartPageIsOpen();
        boolean burgerMenuIsDisplayed = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();

        assertTrue(burgerMenuIsDisplayed, "бургер меню не отображается");
    }

    @Test
    void checkoutButtonIsDisplayed() {
        cartpage.authorizeSndGoToCartPage();
        cartpage.cartPageIsOpen();
        boolean checkoutButtonIsDisplayed = driver.findElement
                (By.xpath("//button[@data-test='checkout' and text()='Checkout']")).isDisplayed();

        assertTrue(checkoutButtonIsDisplayed, "кнопка 'Checkout' не отображается");
    }

    @Test
    void continueShoppingButtonIsDisplayed() {
        cartpage.authorizeSndGoToCartPage();
        cartpage.cartPageIsOpen();
        boolean continueShoppingButtonIsDisplayed = driver.findElement
                        (By.xpath("//button[@data-test='continue-shopping' and text()='Continue Shopping']"))
                .isDisplayed();

        assertTrue(continueShoppingButtonIsDisplayed, "кнопка 'Continue Shopping' не отображается");
    }

    @Test
        //проверка соответствия названия добавленного в корзину товара на Inventory Page названию в корзине
    void addedToCartItemNameCorrespondsItemAtInventoryPage() {
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".btn.btn_primary"));
        List<WebElement> itemsNames = driver.findElements(By.cssSelector(".inventory_item_name "));
        addToCartButtons.get(0).click();
        String firstItemName = itemsNames.get(0).getText();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        String addedItemName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

        assertEquals(firstItemName, addedItemName, "название выбранного товара не соответствует названию товара в корзине");
    }

    @Test
        //проверка соответствия цены добавленного в корзину товара на Inventory Page цене в корзине
    void addedToCartItemPriceCorrespondsItemAtInventoryPage() {
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".btn.btn_primary"));
        List<WebElement> itemsNames = driver.findElements(By.cssSelector(".inventory_item_price"));
        String firstItemPrice = itemsNames.get(0).getText();
        String firstItemPriceNumbers = firstItemPrice.substring(1);
        Double firstItemPriceNumbersDouble = null;
        try {
            firstItemPriceNumbersDouble = Double.parseDouble(firstItemPriceNumbers);
        } catch (NumberFormatException e) {
            System.err.println("Invalid string format: " + e.getMessage());
        }
        addToCartButtons.get(0).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        String addedItemPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"))
                .getText();
        String addedItemPriceNumbers = addedItemPrice.substring(1);
        Double addedItemPriceDouble = null;
        try {
            addedItemPriceDouble = Double.parseDouble(addedItemPriceNumbers);
        } catch (NumberFormatException e) {
            System.err.println("Invalid string format: " + e.getMessage());
        }

        assertEquals(firstItemPriceNumbersDouble, addedItemPriceDouble,
                "цена выбранного товара не соответствует цене товара в корзине");
    }

    @Test
    void itemsDescriptionIsDisplayed() {
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.putProductInCart();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        boolean itemsDescriptionIsDisplayed = driver.findElement(By.cssSelector(".inventory_item_desc")).isDisplayed();
        assertTrue(itemsDescriptionIsDisplayed, "Описание товара не отображается");
    }
}
