package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {

    @Test
    void deveAdicionarProdutoEValidarCarrinho() {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage =
                loginPage.realizarLogin(
                        "standard_user",
                        "secret_sauce"
                );

        productsPage.adicionarProduto("Sauce Labs Backpack");

        CartPage cartPage = productsPage.clicarCarrinho();

        assertTrue(cartPage.isPaginaCarrinhoExibida());

        assertEquals(
                "Sauce Labs Backpack",
                cartPage.obterNomeProduto()
        );
    }
}