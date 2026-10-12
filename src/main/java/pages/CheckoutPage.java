package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By tituloCheckout =
            By.cssSelector("[data-test='title']");

    private final By campoNome =
            By.id("first-name");

    private final By campoSobrenome =
            By.id("last-name");

    private final By campoCep =
            By.id("postal-code");

    private final By botaoContinuar =
            By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validar página de informações do checkout")
    public boolean isPaginaCheckoutExibida() {
        return getText(tituloCheckout)
                .equals("Checkout: Your Information");
    }

    @Step("Informar nome: {nome}")
    public void informarNome(String nome) {
        setText(campoNome, nome);
    }

    @Step("Informar sobrenome: {sobrenome}")
    public void informarSobrenome(String sobrenome) {
        setText(campoSobrenome, sobrenome);
    }

    @Step("Informar CEP")
    public void informarCep(String cep) {
        setText(campoCep, cep);
    }

    @Step("Continuar checkout")
    public CheckoutOverviewPage clicarContinuar() {
        click(botaoContinuar);

        return new CheckoutOverviewPage(driver);
    }
}