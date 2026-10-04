package pages;

import core.BasePage;
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

    public ProductsPage realizarLogin(String usuario, String senha) {

        informarUsuario(usuario);
        informarSenha(senha);

        return clicarLogin();
    }

    public void informarUsuario(String usuario) {
        setText(campoUsuario, usuario);
    }

    public void informarSenha(String senha) {
        setText(campoSenha, senha);
    }

    public ProductsPage clicarLogin() {
        click(botaoLogin);

        return new ProductsPage(driver);
    }

    public String obterMensagemErro() {
        return getText(mensagemErro);
    }
}