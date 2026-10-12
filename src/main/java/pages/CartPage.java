package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By tituloCarrinho =
            By.cssSelector("[data-test='title']");

    private final By nomeProduto =
            By.cssSelector("[data-test='inventory-item-name']");

    private final By botaoCheckout =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validar página do carrinho")
    public boolean isPaginaCarrinhoExibida() {
        return getText(tituloCarrinho).equals("Your Cart");
    }

    @Step("Obter nome do produto no carrinho")
    public String obterNomeProduto() {
        return getText(nomeProduto);
    }

    @Step("Acessar checkout")
    public CheckoutPage clicarCheckout() {
        click(botaoCheckout);

        return new CheckoutPage(driver);
    }
}