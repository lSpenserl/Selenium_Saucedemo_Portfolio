package tests;

import base.BaseTest;
import data.LoginData;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void deveRealizarLoginComSucesso() {

        LoginPage loginPage = new LoginPage(driver);

        assertTrue(
                loginPage
                        .realizarLogin(LoginData.STANDARD_USER, LoginData.VALID_PASSWORD)
                        .isPaginaProdutosExibida()
        );
    }

    @Test
    void deveExibirErroAoInformarSenhaInvalida() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.informarUsuario(LoginData.INVALID_USER);
        loginPage.informarSenha(LoginData.INVALID_PASSWORD);
        loginPage.clicarLogin();

        assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                loginPage.obterMensagemErro()
        );
    }
}