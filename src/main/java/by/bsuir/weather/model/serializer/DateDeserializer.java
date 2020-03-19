package by.bsuir.weather.model.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateDeserializer extends StdDeserializer<LocalDate> {
    public DateDeserializer() {
        this(null);
    }

    protected DateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(Parameter.FORMAT);
        return LocalDate.parse(jsonParser.getValueAsString(), FORMATTER);
    }
}
