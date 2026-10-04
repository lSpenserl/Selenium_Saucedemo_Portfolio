package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void deveRealizarLoginComSucesso() {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage =
                loginPage.realizarLogin("standard_user", "secret_sauce");

        assertTrue(productsPage.isPaginaProdutosExibida());
    }

    @Test
    void deveExibirErroAoInformarSenhaInvalida() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.informarUsuario("standard_user");
        loginPage.informarSenha("senha_invalida");
        loginPage.clicarLogin();

        assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                loginPage.obterMensagemErro()
        );
    }
}