package com.ghazi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;


@ConfigurationProperties(prefix = "ldap")
public class LdapProperties {
    private String url;

    private String base;

    private String userDn;

    private String password;

    // Getters and setters
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }

    public String getUserDn() { return userDn; }
    public void setUserDn(String userDn) { this.userDn = userDn; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
