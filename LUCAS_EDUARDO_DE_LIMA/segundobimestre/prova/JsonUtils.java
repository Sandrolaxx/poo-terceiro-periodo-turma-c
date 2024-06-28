package LUCAS_EDUARDO_DE_LIMA.segundobimestre.prova;

import java.util.*;
import java.util.regex.*;

public class JsonUtils {
    public static List<Map<String, String>> parseJsonArray(String jsonArray) {
        List<Map<String, String>> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{([^}]*)\\}");
        Matcher matcher = pattern.matcher(jsonArray);

        while (matcher.find()) {
            String jsonObject = matcher.group(1);
            list.add(parseJsonObject(jsonObject));
        }

        return list;
    }

    public static Map<String, String> parseJsonObject(String jsonObject) {
        Map<String, String> map = new HashMap<>();
        Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(jsonObject);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            map.put(key, value);
        }

        return map;
    }

    public static String toJsonString(Map<String, String> map) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
        }
        json.deleteCharAt(json.length() - 1);
        json.append("}");
        return json.toString();
    }
}
