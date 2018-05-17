package com.my.config;


import com.my.entity.User;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TestConfiguration extends Configuration {
    @Valid
    @NotNull
    private List<User> users = new ArrayList<User>(){{
        add(new User("Test"));
    }};

    public List<User> getUsers() {
        return users;
    }
}
