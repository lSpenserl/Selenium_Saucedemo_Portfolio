package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By tituloCheckout = By.cssSelector("[data-test='title']");
    private final By mensagemSucesso = By.cssSelector("[data-test='complete-header']");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaginaConclusaoExibida() {
        return getText(tituloCheckout).equals("Checkout: Complete!");
    }

    public String obterMensagemSucesso() {
        return getText(mensagemSucesso);
    }
}