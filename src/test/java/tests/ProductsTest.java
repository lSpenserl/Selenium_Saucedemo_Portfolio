package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsTest extends BaseTest {

    @Test
    void deveAdicionarProdutoAoCarrinho() {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage =
                loginPage.realizarLogin(
                        "standard_user",
                        "secret_sauce"
                );

        productsPage.adicionarProduto("Sauce Labs Backpack");

        assertTrue(productsPage.isProdutoAdicionadoAoCarrinho());

        assertEquals(
                "1",
                productsPage.obterQuantidadeProdutosNoCarrinho()
        );
    }
}