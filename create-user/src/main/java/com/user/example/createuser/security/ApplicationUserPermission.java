package com.user.example.createuser.security;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    TASK_READ("task:read"),
    TASK_WRITE("task:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
