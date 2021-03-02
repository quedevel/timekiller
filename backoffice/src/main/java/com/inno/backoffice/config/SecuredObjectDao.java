package com.inno.backoffice.config;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class SecuredObjectDao {

    private Map<Object, Collection<ConfigAttribute>> rolesAndUrl;

    public Map<Object, Collection<ConfigAttribute>> getRolesAndUrl() {
        Map<Object, Collection<ConfigAttribute>> result = new LinkedHashMap<>();

        return rolesAndUrl;
    }
}
