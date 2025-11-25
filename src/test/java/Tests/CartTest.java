package Tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {


    @Test
    void checkoutButtonIsDisplayed() {
        signInPage.authorization();
        cartpage.open();
        cartpage.cartPageIsOpen();

        assertTrue(cartpage.isCheckoutButtonDisplayed(), "кнопка Checkout не отображается");
    }

    @Test
    void continueShoppingButtonIsDisplayed() {
        signInPage.authorization();
        cartpage.open();
        cartpage.cartPageIsOpen();

        assertTrue(cartpage.isContinueShoppingButtonDisplayed(), "кнопка Continue Shopping не отображается");
    }

    @Test
        //проверка соответствия названия добавленного в корзину товара на Inventory Page названию в корзине
    void addedToCartItemNameCorrespondsItemAtInventoryPage() {
        signInPage.authorization();
        inventoryPage.open();
        inventoryPage.inventoryPageIsOpen();
        List<WebElement> addToCartButtonsList = driver.findElements(inventoryPage.addToCartButtons);
        List<WebElement> itemsNamesList = driver.findElements(inventoryPage.itemsNames);
        addToCartButtonsList.get(0).click();
        String firstItemName = itemsNamesList.get(0).getText();
        inventoryPage.clickOnCartLink();
        String addedItemName = driver.findElement(cartpage.cartItemName).getText();

        assertEquals(firstItemName, addedItemName, "название выбранного товара не соответствует названию товара в корзине");
    }

    @Test
        //проверка соответствия цены добавленного в корзину товара на Inventory Page цене в корзине
    void addedToCartItemPriceCorrespondsItemAtInventoryPage() {
        signInPage.authorization();
        inventoryPage.open();
        inventoryPage.inventoryPageIsOpen();
        List<WebElement> addToCartButtonsList = driver.findElements(inventoryPage.addToCartButtons);
        List<WebElement> itemsNamesList = driver.findElements(inventoryPage.itemsPrices);
        String firstItemPrice = itemsNamesList.get(0).getText();
        String firstItemPriceNumbers = firstItemPrice.substring(1);
        Double firstItemPriceNumbersDouble = null;
        try {
            firstItemPriceNumbersDouble = Double.parseDouble(firstItemPriceNumbers);
        } catch (NumberFormatException e) {
            System.err.println("Invalid string format: " + e.getMessage());
        }
        addToCartButtonsList.get(0).click();
        cartpage.clickOnCartLink();
        String addedItemPrice = driver.findElement(cartpage.addedToCartItemPrice)
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
}
