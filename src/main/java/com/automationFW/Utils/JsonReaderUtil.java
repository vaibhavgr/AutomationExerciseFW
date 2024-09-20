package com.automationFW.Utils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

public class JsonReaderUtil {

	public static  Object getAnyKeyValue(String filePath, String keyToFind) {
        try {
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
            String fileContent = new String(fileBytes, StandardCharsets.UTF_8);

            JSONObject jsonObject = new JSONObject(fileContent);
            return findValue(jsonObject, keyToFind);
        } catch (IOException e) {
            System.out.println("Error reading the jsonTestData file: " + e.getMessage());
        }
        return null;
    }

	private static Object findValue(JSONObject jsonObject, String keyToFind) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static  Map<String, String> convertJsonObjectToHashMap(JSONObject jsonObject) {
		Map<String, String> resultMap = new HashMap<>();
		Iterator<String> keys = jsonObject.keys();

		while (keys.hasNext()) {
			String key = keys.next();
			String value = jsonObject.getString(key);
			resultMap.put(key, value);
		}

		return resultMap;
	}
}
