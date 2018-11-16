package com.qunar.tools.flight.tools.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jiabin.niu on 2018.11.14 10:48
 */
@Component
@ConfigurationProperties(prefix = "self")
public class Self {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
