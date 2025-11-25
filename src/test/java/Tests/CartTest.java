package Tests;

import Pages.CartPage;
import Pages.InventoryPage;

import Pages.Utils.FormatingUtils;
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

        assertTrue(cartpage.isCheckoutButtonDisplayed(), "кнопка Checkout не отображается");
    }

    @Test
    void continueShoppingButtonIsDisplayed() {
        signInPage.authorization();
        cartpage.open();

        assertTrue(cartpage.isContinueShoppingButtonDisplayed(), "кнопка Continue Shopping не отображается");
    }

    @Test
        //проверка соответствия названия добавленного в корзину товара на Inventory Page названию в корзине
    void addedToCartItemNameCorrespondsItemAtInventoryPage() {
        signInPage.authorization();
        inventoryPage.open();
        inventoryPage.inventoryPageIsOpen();
        List<WebElement> addToCartButtonsList = driver.findElements(InventoryPage.ADD_TO_CART_BUTTONS);
        List<WebElement> itemsNamesList = driver.findElements(InventoryPage.ITEMS_NAMES);
        addToCartButtonsList.get(0).click();
        String firstItemName = itemsNamesList.get(0).getText();
        inventoryPage.clickOnCartLink();
        String addedItemName = driver.findElement(CartPage.CART_ITEM_NAME).getText();

        assertEquals(firstItemName, addedItemName, "название выбранного товара не соответствует названию товара в корзине");
    }

    @Test
        //проверка соответствия цены добавленного в корзину товара на Inventory Page цене в корзине
    void addedToCartItemPriceCorrespondsItemAtInventoryPage() {
        signInPage.authorization();
        inventoryPage.open();
        inventoryPage.inventoryPageIsOpen();
        List<WebElement> addToCartButtonsList = driver.findElements(InventoryPage.ADD_TO_CART_BUTTONS);
        List<WebElement> itemsNamesList = driver.findElements(InventoryPage.ITEMS_PRICES);
        String firstItemPrice = itemsNamesList.get(0).getText();
        String firstItemPriceNumbers = firstItemPrice.substring(1);
        double firstItemDoublePrice = FormatingUtils.parseDouble(firstItemPriceNumbers);
        addToCartButtonsList.get(0).click();
        cartpage.clickOnCartLink();
        String addedItemPrice = driver.findElement(CartPage.ADDEED_TO_CART_ITEM_PRICE)
                .getText();
        String addedItemPriceNumbers = addedItemPrice.substring(1);
        double addedItemPriceDouble = FormatingUtils.parseDouble(addedItemPriceNumbers);

        assertEquals(firstItemDoublePrice, addedItemPriceDouble,
                "цена выбранного товара не соответствует цене товара в корзине");
    }
}

