package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By tituloCheckout =
            By.cssSelector("[data-test='title']");

    private final By nomeProduto =
            By.cssSelector("[data-test='inventory-item-name']");

    private final By botaoFinalizar =
            By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validar página de revisão do pedido")
    public boolean isPaginaOverviewExibida() {
        return getText(tituloCheckout)
                .equals("Checkout: Overview");
    }

    @Step("Obter nome do produto na revisão")
    public String obterNomeProduto() {
        return getText(nomeProduto);
    }

    @Step("Finalizar pedido")
    public CheckoutCompletePage clicarFinalizar() {
        click(botaoFinalizar);

        return new CheckoutCompletePage(driver);
    }
}