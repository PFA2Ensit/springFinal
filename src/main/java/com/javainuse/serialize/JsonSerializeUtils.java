package com.javainuse.serialize;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javainuse.model.Annonce;

public class JsonSerializeUtils {
	public static String serializeObjectToString(List<Annonce> list) throws JsonProcessingException{
    	ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		return result;
	}
	
	/*
	 * de-serialize String to Object
	 */
	public static Object deserializeStringToObject(String jsonString, Class<?> valueType) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Object object = mapper.readValue(jsonString, valueType);
		return object;
	}
}
