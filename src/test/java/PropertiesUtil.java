//import com.example.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final Logger logger = LoggerFactory.getLogger(new Object() {}.getClass().getEnclosingClass());
    private static Properties properties = new Properties();

    static {
        try (InputStream input = PropertiesUtil.class
                .getClassLoader()
                .getResourceAsStream("test-config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                logger.error("test-config.properties not found in classpath.");
                throw new RuntimeException("test-config.properties not found in classpath.");
            }
        } catch (IOException e) {
            logger.error("IOException",e);
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
