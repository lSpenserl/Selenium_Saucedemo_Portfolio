package base;

import core.ConfigReader;
import core.DriverFactory;
import data.LoginData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("base.url"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected ProductsPage realizarLogin() {

        LoginPage loginPage = new LoginPage(driver);

        return loginPage.realizarLogin(
                LoginData.STANDARD_USER,
                LoginData.VALID_PASSWORD
        );
    }
}