package br.com.ijuda.api;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.test.context.ActiveProfilesResolver;

public class SpringActiveProfileResolver implements ActiveProfilesResolver {

    private String[] defaultActiveProfile = {"test"};
    private String[] defaultActiveProfileList = {"prod"};

    @Override
    public String[] resolve(Class<?> aClass) {
        final String activeProfileProperty = System.getProperty("spring.profiles.active");
        if(StringUtils.isNotBlank(activeProfileProperty) &&
                ArrayUtils.contains(defaultActiveProfileList, activeProfileProperty)){
            defaultActiveProfile = new String[]{ "homolog-test" };
        }
        return defaultActiveProfile;
    }
}