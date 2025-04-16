package com.ghazi.service;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.core.DirContextAdapter;

import javax.naming.Name;
import java.util.List;

public class LdapGroupService {

    private final LdapTemplate ldapTemplate;

    public LdapGroupService(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public void createGroup(String groupName) {
        Name dn = LdapNameBuilder.newInstance()
                .add("ou", "groups")
                .add("cn", groupName)
                .build();

        DirContextAdapter context = new DirContextAdapter(dn);
        context.setAttributeValue("objectClass", "groupOfNames");
        context.setAttributeValue("cn", groupName);
        ldapTemplate.bind(dn, context , null);
    }

    public void editGroup(String oldGroupName, String newGroupName) {
        Name oldDn = LdapNameBuilder.newInstance()
                .add("ou", "groups")
                .add("cn", oldGroupName)
                .build();

        Name newDn = LdapNameBuilder.newInstance()
                .add("ou", "groups")
                .add("cn", newGroupName)
                .build();

        DirContextAdapter context = new DirContextAdapter(newDn);
        context.setAttributeValue("cn", newGroupName);
        ldapTemplate.rename(oldDn, newDn);
        ldapTemplate.modifyAttributes(newDn, context.getModificationItems());
    }

    public void deleteGroup(String groupName) {
        Name dn = LdapNameBuilder.newInstance()
                .add("ou", "groups")
                .add("cn", groupName)
                .build();
        ldapTemplate.unbind(dn);
    }

    public List<String> findAllGroups() {
        return ldapTemplate.search(
                LdapQueryBuilder.query()
                        .where("objectClass").is("groupOfNames"),
                (AttributesMapper<String>) (attrs) -> attrs.get("cn").get().toString()
        );
    }
}

