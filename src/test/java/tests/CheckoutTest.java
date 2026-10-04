package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    void deveFinalizarCompraComSucesso() {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage =
                loginPage.realizarLogin(
                        "standard_user",
                        "secret_sauce"
                );

        productsPage.adicionarProduto("Sauce Labs Backpack");

        CartPage cartPage = productsPage.clicarCarrinho();

        CheckoutPage checkoutPage = cartPage.clicarCheckout();

        checkoutPage.informarNome("Leandro");
        checkoutPage.informarSobrenome("Barboza");
        checkoutPage.informarCep("06700-000");

        CheckoutOverviewPage overviewPage =
                checkoutPage.clicarContinuar();

        assertTrue(overviewPage.isPaginaOverviewExibida());

        assertEquals(
                "Sauce Labs Backpack",
                overviewPage.obterNomeProduto()
        );

        CheckoutCompletePage completePage =
                overviewPage.clicarFinalizar();

        assertTrue(completePage.isPaginaConclusaoExibida());

        assertEquals(
                "Thank you for your order!",
                completePage.obterMensagemSucesso()
        );
    }
}