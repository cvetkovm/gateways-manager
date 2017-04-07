package org.cvetkov.martin.utilities;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class StatusToStringSerializer extends JsonSerializer<DeviceStatus> {
	
	@Override
	public void serialize(DeviceStatus status, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String statusLowerCase = status.name().toLowerCase();
		String resultingString = statusLowerCase.substring(0, 1).toUpperCase() + statusLowerCase.substring(1); 
		jsonGenerator.writeString(resultingString);
	}
	
}