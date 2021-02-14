package objectivetester;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Steve
 */
public class DefaultWriter {

    UserInterface ui;
    int footer = 0;
    int n;

    void writeHeader() {
    }

    void writeStart() {
        n++;
        ui.insertCode("\n    @Test\n"
                + "    public void test" + n + "() {", footer);
    }

    void writeAssert(String node, String value) {
        ui.insertCode("\n        //assert:" + node + "=" + value + "\n"
                // some code
                + "        .body(\"" + node + "\", equalTo(\"" + value + "\"))"
                + "", footer + 3);
    }

    void writeGet(String url, int code, String rawHeaders, String rawCookies) {

        String testCookies = "";
        String testHeaders = "";

        if (!rawCookies.isEmpty()) {
            String[] c = rawCookies.split("\\s*,\\s*");
            ArrayList<String> cookies = new ArrayList<>(Arrays.asList(c));
            for (String cookie : cookies) {
                if (cookie.contains("=")) {
                    String key = cookie.substring(0, cookie.indexOf("="));
                    String val = cookie.substring(1 + cookie.indexOf("="), cookie.length());
                    testCookies = testCookies + ".cookie(\"" + key + "\", \"" + val + "\")";
                }
            }
        }

        if (!rawHeaders.isEmpty()) {
            String[] h = rawHeaders.split("\\s*,\\s*");
            ArrayList<String> headers = new ArrayList<>(Arrays.asList(h));

            for (String header : headers) {
                if (header.contains("=")) {
                    String key = header.substring(0, header.indexOf("="));
                    String val = header.substring(1 + header.indexOf("="), header.length());
                    testHeaders = testHeaders + ".header(\"" + key + "\", \"" + val + "\")";
                }
            }
        }

        ui.insertCode("\n        //get:" + url + "\n"
                + "        given().when()" + testHeaders + testCookies + ".get(\"" + url + "\").then()\n"
                + "        .statusCode(" + code + ");\n"
                + "", footer);
    }

    void writePost(String url, String data, int code, String rawHeaders, String rawCookies) {
        String testCookies = "";
        String testHeaders = "";

        if (!rawCookies.isEmpty()) {
            String[] c = rawCookies.split("\\s*,\\s*");
            ArrayList<String> cookies = new ArrayList<>(Arrays.asList(c));
            for (String cookie : cookies) {
                String key = cookie.substring(0, cookie.indexOf("="));
                String val = cookie.substring(1 + cookie.indexOf("="), cookie.length());
                testCookies = testCookies + ".cookie(\"" + key + "\", \"" + val + "\")";
            }
        }

        if (!rawHeaders.isEmpty()) {
            String[] h = rawHeaders.split("\\s*,\\s*");
            ArrayList<String> headers = new ArrayList<>(Arrays.asList(h));

            for (String header : headers) {
                String key = header.substring(0, header.indexOf("="));
                String val = header.substring(1 + header.indexOf("="), header.length());
                testHeaders = testHeaders + ".header(\"" + key + "\", \"" + val + "\")";
            }
        }

        ui.insertCode("\n        //post:" + url + "\n"
                + "        String data = \"" + data + "\";\n"
                + "        given().when()" + testHeaders + testCookies + ".contentType(\"application/json\")"
                + ".body(data).post(\"" + url + "\").then()\n"
                + "        .statusCode(" + code + ");\n"
                + "", footer);
    }

    void writeDelete(String url, int code, String rawHeaders, String rawCookies) {
        String testCookies = "";
        String testHeaders = "";

        if (!rawCookies.isEmpty()) {
            String[] c = rawCookies.split("\\s*,\\s*");
            ArrayList<String> cookies = new ArrayList<>(Arrays.asList(c));
            for (String cookie : cookies) {
                String key = cookie.substring(0, cookie.indexOf("="));
                String val = cookie.substring(1 + cookie.indexOf("="), cookie.length());
                testCookies = testCookies + ".cookie(\"" + key + "\", \"" + val + "\")";
            }
        }

        if (!rawHeaders.isEmpty()) {
            String[] h = rawHeaders.split("\\s*,\\s*");
            ArrayList<String> headers = new ArrayList<>(Arrays.asList(h));

            for (String header : headers) {
                String key = header.substring(0, header.indexOf("="));
                String val = header.substring(1 + header.indexOf("="), header.length());
                testHeaders = testHeaders + ".header(\"" + key + "\", \"" + val + "\")";
            }
        }

        ui.insertCode("\n        //delete:" + url + "\n"
                + "        given().when()" + testHeaders + testCookies + ".delete(\"" + url + "\").then()\n"
                + "        .statusCode(" + code + ");\n"
                + "", footer);
    }

    void writeEnd() {
        ui.insertCode("    }\n", footer);
    }

}
