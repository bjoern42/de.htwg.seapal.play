package models;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class CustomJsonDateSerializer extends JsonSerializer<Date>
{
	@Override
	public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jgen.writeString(format.format(date));
		
	}
}
