package org.marco.poc.poceurekaconfigserver.serviceclient.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public final class LogUtil {

  private static final ObjectWriter OBJECT_WRITER =
      new ObjectMapper().writerWithDefaultPrettyPrinter();

  private LogUtil() {}

    public static String objectToJson(Object object) {
        try {
        return OBJECT_WRITER.writeValueAsString(object);
        } catch (Exception e) {
        return "Error converting object to JSON";
        }
    }
}
