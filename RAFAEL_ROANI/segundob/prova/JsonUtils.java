package segundobimestre.prova;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {
    public static Map<String, Object> toMap(String json) {
        Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(json);

        Map<String, Object> jsonData = new HashMap<>();

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);

            jsonData.put(key, value.replace("\"", ""));
        }

        return jsonData;
    }
}
