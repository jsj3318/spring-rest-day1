package com.nhnacademy.daily.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@JsonComponent
public class JacksonConfig {

    public static class LocalDateSerializer extends StdSerializer<LocalDate> {
        private static final long serialVersionUID = -7524016618355224119L;

        public LocalDateSerializer() {
            super(LocalDate.class);
        }

        @Override
        public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String str = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            jsonGenerator.writeString(str);
        }
    }

}
