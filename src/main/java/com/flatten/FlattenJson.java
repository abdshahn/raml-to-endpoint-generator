package com.flatten;

import java.util.HashMap;

public class FlattenJson {
	public static HashMap<String, Object> flattenJson(HashMap<String, Object> input) {
		System.out.println("function started");
		HashMap<String, Object> output = new HashMap<String, Object>();
		flatten(input, "", output);
		System.out.println("function ended");
		return output;
	}

	static void flatten(HashMap<String, Object> nestedMap, String prefix, HashMap<String, Object> flattenedMap) {
		for (HashMap.Entry<String, Object> entry : nestedMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof HashMap) {
				flatten((HashMap<String, Object>) value, prefix + key + ".", flattenedMap);
			} else {
				flattenedMap.put(prefix + key, value);
			}
		}
	}

}
