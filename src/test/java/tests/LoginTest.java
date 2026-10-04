package tests;

import base.BaseTest;
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
                        .realizarLogin("standard_user", "secret_sauce")
                        .isPaginaProdutosExibida()
        );
    }

    @Test
    void deveExibirErroAoInformarSenhaInvalida() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.informarUsuario("standard_user_Invalido");
        loginPage.informarSenha("secret_sauce_invalido");
        loginPage.clicarLogin();

        assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                loginPage.obterMensagemErro()
        );
    }
}