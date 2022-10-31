package br.com.ijuda.api.token.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MvcResultUtil {

    @Autowired
    private ObjectMapper objectMapper;

    public <T> T converterResult(String contentAsString, TypeReference<T> typeReference ) throws JsonProcessingException {
        return objectMapper.readValue(contentAsString, typeReference);
    }

}
