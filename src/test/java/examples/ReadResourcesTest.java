package examples;

import io.qameta.allure.Link;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.PropertyReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ReadResourcesTest {
    @Link("Cool video")
    @Disabled
    @Test
    public void readPropertiesfromResourcesTest() {
        Properties properties = PropertyReader.getProperties();
        String browser = properties.getProperty("browser");
        assertEquals("chrome", browser);
    }
    @Disabled
    @Test
    public void readTextFromResourcesTest() {
        String filePath = "attachments/text.txt";
        String text = "";
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            text = sb.toString();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        assertTrue( text.contains("random text"), text + "is not what we expected");
    }
    @Disabled
    @Test
    public void simplifiedResourceRead() {
        String filePath = "attachments/text.txt";
        String text = "";
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
            text = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assertTrue(text.contains("random text"), text + "is not what we expected");
    }


}
