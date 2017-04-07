package org.cvetkov.martin.utilities;

import java.io.IOException;

import org.cvetkov.martin.error.DeviceStatusNotValidException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class StringToStatusSerializer  extends JsonDeserializer<DeviceStatus> {

	@Override
	public DeviceStatus deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String status = node.asText();
        if(status == null || 
        		(!status.equalsIgnoreCase(DeviceStatus.OFFLINE.name()) && !status.equalsIgnoreCase(DeviceStatus.ONLINE.name()))) {
        	throw new DeviceStatusNotValidException();
        }
        
        if(status.equalsIgnoreCase(DeviceStatus.ONLINE.name())) {
        	return DeviceStatus.ONLINE;
        } else {
        	return DeviceStatus.OFFLINE;
        }
	}

}
