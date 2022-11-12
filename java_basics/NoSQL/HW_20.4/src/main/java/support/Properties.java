package support;

import java.io.IOException;

public class Properties {
  private static java.util.Properties properties;

  protected static String getProperty(String propertyKey) throws IOException {

    if (properties == null) {
      Properties.init();
    }

    return properties.getProperty(propertyKey);
  }

  protected static void init() throws IOException {
    properties = new java.util.Properties();
    properties.load(ClassLoader.getSystemResourceAsStream("application.properties"));
  }

}
