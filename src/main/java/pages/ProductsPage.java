package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By tituloProdutos = By.cssSelector("[data-test='title']");
    private final By carrinho = By.cssSelector(".shopping_cart_link");
    private final By contadorCarrinho = By.cssSelector(".shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaginaProdutosExibida() {
        return getText(tituloProdutos).equals("Products");
    }

    public void adicionarProduto(String nomeProduto) {

        String nomeProdutoFormatado = nomeProduto
                .toLowerCase()
                .replace(" ", "-");

        By botaoAdicionarProduto = By.cssSelector(
                "[data-test='add-to-cart-" + nomeProdutoFormatado + "']"
        );

        click(botaoAdicionarProduto);
    }

    public boolean isProdutoAdicionadoAoCarrinho() {
        return isDisplayed(contadorCarrinho);
    }

    public String obterQuantidadeProdutosNoCarrinho() {
        return getText(contadorCarrinho);
    }
    public CartPage clicarCarrinho() {
        click(carrinho);

        return new CartPage(driver);
    }
}