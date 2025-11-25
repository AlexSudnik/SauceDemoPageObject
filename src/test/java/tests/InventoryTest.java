package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    void pageIsOpen() {
        signInPage.authorization();
        inventoryPage.open();

        assertTrue(inventoryPage.inventoryPageIsOpen(), "страница Inventory не открылась");
    }

    @Test
    void pageMustContains6Products() {
        signInPage.authorization();
        inventoryPage.open();
        inventoryPage.inventoryPageIsOpen();

        assertEquals(6, inventoryPage.getProductsOnInventoryNamesSize(), "на странице не отображается 6 товаров");
    }

    @Test
    void PageMustContains6Prices() {
        signInPage.authorization();
        inventoryPage.open();
        inventoryPage.inventoryPageIsOpen();

        assertEquals(6, inventoryPage.getProductsOnInventoryPricesSize(), "цены на 6 товаров не отображаются");
    }

    @Test
    void cartButtonIsDisplayed() {
        signInPage.authorization();
        inventoryPage.open();
        inventoryPage.cartButtonIsDisplayed();

        assertTrue(inventoryPage.cartButtonIsDisplayed(), "кнопка корзины не отображается");
    }
}

