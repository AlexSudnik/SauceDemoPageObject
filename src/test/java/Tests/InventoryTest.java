package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InventoryTest extends BaseTest{

    @Test
    void pageIsOpen(){
        inventoryPage.authorizeAndGoToInventaryPage();

        assertTrue(inventoryPage.inventoryPageIsOpen(), "страница Inventory не открылась");
    }

    @Test
    void pageMustContains6Products(){
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        List<WebElement> productsOnInventoryPageTitles = driver.findElements(By.cssSelector(".inventory_item_description"));

        assertEquals(6, productsOnInventoryPageTitles.size(), "на странице не отображается 6 товаров");
    }

    @Test
    void PageMustContains6Prices(){
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        List<WebElement> productsOnInventoryPagePrices = driver.findElements(By.cssSelector(".inventory_item_price"));
        assertEquals(6, productsOnInventoryPagePrices.size(), "цены на 6 товаров не отображаются");
    }

    @Test
    void cartButtonIsDisplayed(){
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        boolean cartButtonIsDisplayed = driver.findElement(By.cssSelector(".shopping_cart_link")).isDisplayed();

        assertTrue(cartButtonIsDisplayed, "кнопка корзины не отображается");
    }

    @Test
    void burgerMenuIsDisplayed() {
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        boolean burgerMenuIsDisplayed = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();

        assertTrue(burgerMenuIsDisplayed, "бургер меню не отображается");
    }

    @Test
    void burgerMenuContains4Elements(){
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        List<WebElement> burgerMenuElements = driver.findElements(By.cssSelector(".bm-item.menu-item"));

        assertEquals(4, burgerMenuElements.size(), "в бургер-меню не отображается 4 элемента");
    }

    @Test
    void textOnAddToCartButtonIsAdToCart(){
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        String addToCartButtonText = driver.findElement(By.cssSelector(".btn_small.btn_inventory")).getText();

        assertEquals(addToCartButtonText, "Add to cart", "текст Add to cart не отображается");
    }

    @Test
    void textOnAddToCartButtonIsChangedToRemoveAfterAddingToCart(){
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        driver.findElement(By.cssSelector(".btn_small.btn_inventory")).click();
        String removeButtonText = driver.findElement(By.cssSelector(".btn_small.btn_inventory")).getText();

        assertEquals(removeButtonText, "Remove", "текст Remove не отображается на кнопке");
    }

    @Test
    void cartIconIsChangedAfterAddingProductToCart(){
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        driver.findElement(By.cssSelector(".btn_small.btn_inventory")).click();
        boolean itemsInCartIconIsDisplayed = driver.findElement(By.cssSelector(".shopping_cart_link")).isDisplayed();

        assertTrue(itemsInCartIconIsDisplayed, "иконка наличия товара в корзине не отображается");
    }

    @Test
    void sortContainerIsDisplayed(){
        inventoryPage.authorizeAndGoToInventaryPage();
        inventoryPage.inventoryPageIsOpen();
        boolean sortContainerIsDisplayed =
                driver.findElement(By.xpath("//select[@class='product_sort_container']")).isDisplayed();

        assertTrue(sortContainerIsDisplayed, "фильтр не отображается");
    }
}



