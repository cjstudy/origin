package com.mini.base.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 参数配置
 * @author Caesar Liu
 * @date 2019/6/3 17:59
 */
public class ParamConfig {

    /**
     * LocalDateTime(yyyy-MM-dd)
     * @author Caesar Liu
     * @date 2019/6/3 18:08
     */
    public static class DateDeserializer extends JsonDeserializer<LocalDateTime> {

        @Override
        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (StringUtils.isBlank(jsonParser.getText()))
                return null;
            if (jsonParser.getText().length() > 10)
                return LocalDateTime.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDate localDate = LocalDate.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return LocalDateTime.of(localDate, LocalTime.MIN);
        }
    }
}
