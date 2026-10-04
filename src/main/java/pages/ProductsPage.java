package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By tituloProdutos = By.cssSelector("[data-test='title']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaginaProdutosExibida() {
        return getText(tituloProdutos).equals("Products");
    }
}