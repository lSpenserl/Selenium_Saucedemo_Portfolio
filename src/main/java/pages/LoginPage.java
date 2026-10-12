package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By campoUsuario = By.id("user-name");
    private final By campoSenha = By.id("password");
    private final By botaoLogin = By.id("login-button");
    private final By mensagemErro = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Informar usuário: {usuario}")
    public void informarUsuario(String usuario) {
        setText(campoUsuario, usuario);
    }

    @Step("Informar senha")
    public void informarSenha(String senha) {
        setText(campoSenha, senha);
    }

    @Step("Clicar em Login")
    public ProductsPage clicarLogin() {
        click(botaoLogin);

        return new ProductsPage(driver);
    }

    @Step("Realizar login com usuário: {usuario}")
    public ProductsPage realizarLogin(String usuario, String senha) {

        informarUsuario(usuario);
        informarSenha(senha);

        return clicarLogin();
    }

    public String obterMensagemErro() {
        return getText(mensagemErro);
    }
}