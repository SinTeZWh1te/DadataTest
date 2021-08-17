package ru.test.bgbilling.dadata.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author sintezwh1te
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        long epochMillis = parser.getLongValue();
        return Instant.ofEpochMilli(epochMillis).atZone(ZoneId.of("UTC")).toLocalDate();
    }
}
