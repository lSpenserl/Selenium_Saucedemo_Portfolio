package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver() {

        String browser = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(
                ConfigReader.get("headless")
        );

        if (browser == null || browser.isBlank()) {
            throw new RuntimeException(
                    "Configuração 'browser' não encontrada."
            );
        }

        return switch (browser.toLowerCase()) {
            case "chrome" -> createChromeDriver(headless);
            case "edge" -> createEdgeDriver(headless);
            case "firefox" -> createFirefoxDriver(headless);

            default -> throw new RuntimeException(
                    "Browser não suportado: " + browser
            );
        };
    }

    private static WebDriver createChromeDriver(boolean headless) {

        ChromeOptions options = new ChromeOptions();

        configureChrome(options);

        if (headless) {
            options.addArguments("--headless=new");
        }

        return new ChromeDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headless) {

        EdgeOptions options = new EdgeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        if (headless) {
            options.addArguments("--headless=new");
        }

        return new EdgeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless) {

        FirefoxOptions options = new FirefoxOptions();

        if (headless) {
            options.addArguments("--headless");
        }

        return new FirefoxDriver(options);
    }

    private static void configureChrome(ChromeOptions options) {

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments(
                "--disable-features=PasswordLeakDetection"
        );
    }
}