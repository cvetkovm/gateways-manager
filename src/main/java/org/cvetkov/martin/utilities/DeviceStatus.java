package org.cvetkov.martin.utilities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = StatusToStringSerializer.class, as=String.class)
@JsonDeserialize(using = StringToStatusSerializer.class, as=DeviceStatus.class)
public enum DeviceStatus {
	ONLINE, OFFLINE;
}
