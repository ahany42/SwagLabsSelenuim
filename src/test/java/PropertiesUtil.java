//import com.example.utils.PropertiesUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = PropertiesUtil.class
                .getClassLoader()
                .getResourceAsStream("test-config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("test-config.properties not found in classpath.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
