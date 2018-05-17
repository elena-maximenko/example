package com.my.config;

import com.my.entity.User;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HelloWorldConfiguration extends Configuration {
    @Valid
    @NotNull
    private User user = new User();

    public User getUser() {
        return user;
    }
}