package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By tituloCheckout = By.cssSelector("[data-test='title']");
    private final By campoNome = By.id("first-name");
    private final By campoSobrenome = By.id("last-name");
    private final By campoCep = By.id("postal-code");
    private final By botaoContinuar = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaginaCheckoutExibida() {
        return getText(tituloCheckout).equals("Checkout: Your Information");
    }

    public void informarNome(String nome) {
        setText(campoNome, nome);
    }

    public void informarSobrenome(String sobrenome) {
        setText(campoSobrenome, sobrenome);
    }

    public void informarCep(String cep) {
        setText(campoCep, cep);
    }

    public CheckoutOverviewPage clicarContinuar() {
        click(botaoContinuar);

        return new CheckoutOverviewPage(driver);
    }
}