package com.elixirgreen.starkabaddi;

/**
 * Created by abhilash on 29/4/16.
 */

public class ServerRequest {

    private String operation;
    private User user;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}