package com.user.example.createuser.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.user.example.createuser.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    MEMBER(Sets.newHashSet(USER_READ, USER_WRITE)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, TASK_READ, TASK_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
