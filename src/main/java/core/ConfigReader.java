package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("Arquivo config.properties não encontrado.");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o config.properties.", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}