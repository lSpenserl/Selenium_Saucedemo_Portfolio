package tests;

import base.BaseTest;
import data.ProductData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ProductsPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("products")
public class ProductsTest extends BaseTest {

    @Tag("regression")
    @ParameterizedTest(name = "Deve adicionar o produto: {0}")
    @MethodSource("produtos")
    void deveAdicionarProdutoAoCarrinho(String nomeProduto) {

        ProductsPage productsPage = realizarLogin();

        productsPage.adicionarProduto(nomeProduto);

        assertTrue(productsPage.isProdutoAdicionadoAoCarrinho());

        assertEquals(
                "1",
                productsPage.obterQuantidadeProdutosNoCarrinho()
        );
    }

    static Stream<String> produtos() {
        return Stream.of(
                ProductData.BACKPACK,
                ProductData.BIKE_LIGHT,
                ProductData.BOLT_T_SHIRT
        );
    }
}