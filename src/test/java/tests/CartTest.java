package tests;

import base.BaseTest;
import data.ProductData;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {

    @Test
    void deveAdicionarProdutoEValidarCarrinho() {

        ProductsPage productsPage = realizarLogin();

        productsPage.adicionarProduto(ProductData.BACKPACK);

        CartPage cartPage = productsPage.clicarCarrinho();

        assertTrue(cartPage.isPaginaCarrinhoExibida());

        assertEquals(
                "Sauce Labs Backpack",
                cartPage.obterNomeProduto()
        );
    }
}