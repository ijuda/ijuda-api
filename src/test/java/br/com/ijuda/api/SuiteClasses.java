package br.com.ijuda.api;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(JUnitPlatform.class)
@SelectPackages({

})
@SuiteDisplayName("Testes do Ijuda API")
@Suite.SuiteClasses({
        // API

})
public class SuiteClasses {
}
