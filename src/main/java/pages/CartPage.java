package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By tituloCarrinho = By.cssSelector("[data-test='title']");
    private final By nomeProduto = By.cssSelector("[data-test='inventory-item-name']");
    private final By botaoCheckout = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaginaCarrinhoExibida() {
        return getText(tituloCarrinho).equals("Your Cart");
    }

    public String obterNomeProduto() {
        return getText(nomeProduto);
    }

    public CheckoutPage clicarCheckout() {
        click(botaoCheckout);

        return new CheckoutPage(driver);
    }
}