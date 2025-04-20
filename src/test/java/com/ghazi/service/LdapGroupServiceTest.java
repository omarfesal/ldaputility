package com.ghazi.service;

import com.ghazi.config.GhaziLdapAutoConfiguration;
import com.ghazi.config.LdapProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ContextConfiguration(classes = TestConfig.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application-test.properties")
class LdapGroupServiceTest {


    @Autowired
    private LdapProperties ldapProperties;

    @Autowired
    LdapGroupService ldapGroupService;

    @Test
    public void testLdapProperties() {
        // Assert that properties are loaded correctly from the properties file
        assertNotNull(ldapProperties);
        assertEquals("ldap://localhost:389", ldapProperties.getUrl());
        assertEquals("dc=example,dc=com", ldapProperties.getBase());
        assertEquals("cn=admin", ldapProperties.getUserDn());
        assertEquals("password123", ldapProperties.getPassword());
    }

    @Test
    void findAllGroups() {

//        ldapGroupService.createGroup("ADMINS");

        ldapGroupService.createGroupsOrganizationalUnit();

        ldapGroupService.createGroup("TEST");

    }
}