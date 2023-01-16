package com.atmostadam.cats.api.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@Accessors(fluent = false, chain = true)
@ConfigurationProperties
public class CatWebClientProperties {
    private String url;
    private String method;
    private String username;
    private String password;
    private int connectionTimeout;
    private int responseTimeout;
    private int readTimeout;
    private int writeTimeout;
}
