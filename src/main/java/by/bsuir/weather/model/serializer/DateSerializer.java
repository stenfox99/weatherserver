package by.bsuir.weather.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DateSerializer extends StdSerializer<LocalDate> {
    public DateSerializer(){
        this(null);
    }

    public DateSerializer(Class<LocalDate> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SimpleDateFormat FORMATTER = new SimpleDateFormat(Parameter.FORMAT);
        jsonGenerator.writeString(FORMATTER.format(Date.valueOf(localDate)));
    }

}
