package utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtils {

    private JSONUtils() {
    }

    public static String getJsonFileContentsAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static JSONObject getFileContentsAsJsonObject(String filePath) throws IOException {
        return new JSONObject(getJsonFileContentsAsString(filePath));
    }
}
