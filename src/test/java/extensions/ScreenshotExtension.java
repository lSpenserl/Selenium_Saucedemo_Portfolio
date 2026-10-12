package extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class ScreenshotExtension implements AfterTestExecutionCallback {

    private final Supplier<WebDriver> driverSupplier;

    public ScreenshotExtension(Supplier<WebDriver> driverSupplier) {
        this.driverSupplier = driverSupplier;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {

        if (context.getExecutionException().isEmpty()) {
            return;
        }

        WebDriver driver = driverSupplier.get();

        if (!(driver instanceof TakesScreenshot screenshotDriver)) {
            return;
        }

        try {
            Path screenshotDirectory = Paths.get(
                    "target",
                    "screenshots"
            );

            Files.createDirectories(screenshotDirectory);

            String testName = context.getDisplayName()
                    .replaceAll("[^a-zA-Z0-9-_]", "_");

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            Path screenshotPath = screenshotDirectory.resolve(
                    testName + "_" + timestamp + ".png"
            );

            byte[] screenshot = screenshotDriver.getScreenshotAs(
                    OutputType.BYTES
            );

            Files.write(screenshotPath, screenshot);

            System.out.println(
                    "Screenshot salvo em: " + screenshotPath
            );

        } catch (IOException e) {
            System.err.println(
                    "Erro ao salvar screenshot: " + e.getMessage()
            );
        }
    }
}