package com.example.sneakpeak.Configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PayPalConfig {

    @Bean
    public Map<String, String> paypalSdkConfig() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("mode", "sandbox");
        return configMap;
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential("AagERNivDC_wBaYAWAdCrerOtNTAhd9vNLJUrKzhFRO0EohaebqEXB_EzIN6kZT0w2fQuN5SnCOUHIpn", "EPIV_xFUX3DdEJ5mjtThdfBEwKCe7GwOQQ3VuCoIYCFqc2ssb4WVnWJjyYCf6joDvcqFZJiuHbrZSMzE", paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return context;
    }
}
