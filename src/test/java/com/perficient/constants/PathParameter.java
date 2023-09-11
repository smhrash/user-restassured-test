package com.perficient.constants;

public enum PathParameter {
    CREATE_USER("user_app/v1/users"),
    UPDATE_USER("user_app/v1/users"),
    DELETE_USER("user_app/v1/users/"),
    GET_USER("user_app/v1/users/"),
    GET_USERS("user_app/v1/users");
    private final String param;

    PathParameter(String param) {
        this.param = param;
    }

    public String param() {
        return param;
    }
}
