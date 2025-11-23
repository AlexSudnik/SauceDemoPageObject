package Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

    @Test
    void userShouldBeSignInWithValidNaneAndPassword() {
        signInPage.open();
        signInPage.inputLogin("standard_user");
        signInPage.inputPassword("secret_sauce");
        signInPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();

        assertTrue(inventoryPage.inventoryPageIsOpen(), "Страница не открыта");
    }

    @Test
    void inputsLoginShouldBeRequired() {
        signInPage.open();
        signInPage.inputLogin("");
        signInPage.inputPassword("secret_sauce");
        signInPage.clickLoginButton();

        assertEquals(signInPage.getErrorMessage(),
                "Epic sadface: Username is required", "Текст сообщения не соответствцет ожидаемому");
    }

    @Test
    void inputsPasswordShouldBeRequired() {
        signInPage.open();
        signInPage.inputLogin("standard_user");
        signInPage.inputPassword("");
        signInPage.clickLoginButton();

        assertEquals(signInPage.getErrorMessage(),
                "Epic sadface: Password is required", "Текст сообщения не соответствцет ожидаемому");


    }
}
