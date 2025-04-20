package com.ghazi.service;

import com.ghazi.config.LdapProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;

@Configuration
@ComponentScan(basePackages = "com.ghazi.*")
@EnableConfigurationProperties(LdapProperties.class)
public class TestConfig {
}