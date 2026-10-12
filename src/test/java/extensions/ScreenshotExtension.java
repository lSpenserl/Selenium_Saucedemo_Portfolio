package extensions;

import io.qameta.allure.Allure;
import io.qameta.allure.AttachmentOptions;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
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

        // Só captura screenshot quando o teste falhar
        if (context.getExecutionException().isEmpty()) {
            return;
        }

        WebDriver driver = driverSupplier.get();

        if (!(driver instanceof TakesScreenshot screenshotDriver)) {
            return;
        }

        try {

            // Captura o screenshot
            byte[] screenshot = screenshotDriver.getScreenshotAs(
                    OutputType.BYTES
            );

            // Anexa o screenshot ao Allure
            Allure.attachment(
                    "Screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    AttachmentOptions.withFileExtension(".png")
            );

            // Diretório para salvar o screenshot fisicamente
            Path screenshotDirectory = Paths.get(
                    "target",
                    "screenshots"
            );

            Files.createDirectories(screenshotDirectory);

            // Nome do teste
            String testName = context.getDisplayName()
                    .replaceAll("[^a-zA-Z0-9-_]", "_");

            // Timestamp
            String timestamp = LocalDateTime.now()
                    .format(
                            DateTimeFormatter.ofPattern(
                                    "yyyyMMdd_HHmmss"
                            )
                    );

            // Caminho final do arquivo
            Path screenshotPath = screenshotDirectory.resolve(
                    testName + "_" + timestamp + ".png"
            );

            // Salva o screenshot
            Files.write(
                    screenshotPath,
                    screenshot
            );

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