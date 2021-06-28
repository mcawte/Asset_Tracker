package com.acme;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Config {
    private Configuration config;

    public Config() {
        Configurations configs = new Configurations();
        try {
            config = configs.properties(new File("application.properties"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return config.getString(key);
    }
}
