package tests;

import base.BaseTest;
import data.ProductData;
import org.junit.jupiter.api.Test;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsTest extends BaseTest {

    @Test
    void deveAdicionarProdutoAoCarrinho() {

        ProductsPage productsPage = realizarLogin();

        productsPage.adicionarProduto(ProductData.BACKPACK);

        assertTrue(productsPage.isProdutoAdicionadoAoCarrinho());

        assertEquals(
                "1",
                productsPage.obterQuantidadeProdutosNoCarrinho()
        );
    }
}