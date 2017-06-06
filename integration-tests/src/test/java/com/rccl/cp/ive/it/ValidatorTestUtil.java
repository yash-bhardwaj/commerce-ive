package com.rccl.cp.ive.it;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ValidatorTestUtil {
    private ValidatorTestUtil() {
    }

    static final Logger logger =
        LoggerFactory.getLogger(ValidatorTestUtil.class);

    /**
     * Load a response JSON file with the given name.
     *
     * @param responseName
     *            The name of the response to load
     * @return The response JSON as a String, or <code>null</code> if it cannot
     *         be loaded
     */
    public static String loadResponse(final String responseName) {
        return loadResource("/responses/" + responseName + ".json");
    }

    /**
     * Load a request JSON file with the given name.
     *
     * @param requestName
     *            The name of the request to load
     * @return The response JSON as a String, or <code>null</code> if it cannot
     *         be loaded
     */
    public static String loadRequest(final String requestName) {
        return loadResource("/requests/" + requestName + ".json");
    }

    private static String loadResource(final String path) {
        String output = null;
        InputStream stream = null;
        BufferedReader reader = null;
        try {
            stream = ValidatorTestUtil.class.getResourceAsStream(path);
            reader = new BufferedReader(new InputStreamReader(stream));
            final StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append('\n');
            }
            output = builder.toString();
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
        } catch (final Exception e) {
            logger.error("loadResource({}) Got Exception {}", path, e.getMessage());
        }
        return output;
    }
}
