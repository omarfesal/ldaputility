package com.ghazi.config;

import com.ghazi.service.LdapGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;


@Configuration
@EnableConfigurationProperties(LdapProperties.class)
@ConditionalOnProperty(prefix = "ldap", name = "url")
public class GhaziLdapAutoConfiguration {

    Logger LOGGER = LoggerFactory.getLogger(GhaziLdapAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public LdapContextSource ldapContextSource(LdapProperties properties) {
        LOGGER.info("Initialize ldapContextSource");
        LdapContextSource source = new LdapContextSource();
        source.setUrl(properties.getUrl());
        source.setBase(properties.getBase());
        source.setUserDn(properties.getUserDn());
        source.setPassword(properties.getPassword());
        source.afterPropertiesSet();
        return source;
    }

    @Bean
    @ConditionalOnMissingBean
    public LdapTemplate ldapTemplate(LdapContextSource source) {
        return new LdapTemplate(source);
    }

    @Bean
    @ConditionalOnMissingBean
    public LdapGroupService ldapGroupService(LdapTemplate ldapTemplate) {
        return new LdapGroupService(ldapTemplate);
    }
}
