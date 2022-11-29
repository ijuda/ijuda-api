package br.com.ijuda.api.token.util;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class StringUtil {

    private StringUtil() {
    }

    public static String fromObject(Object o) {
        if (Objects.isNull(o))
            return null;
        else {
            return String.valueOf(o);
        }
    }

    public static String numberFromObject(Object o) {
        if (Objects.isNull(o) || StringUtils.isBlank(String.valueOf(o)))
            return "0";
        else {
            return String.valueOf(o);
        }
    }
}