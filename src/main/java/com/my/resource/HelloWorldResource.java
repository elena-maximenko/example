package com.my.resource;

import com.my.entity.User;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/welcome")
public class HelloWorldResource {

    @Inject
    User user;

    public HelloWorldResource() {
    }

    public HelloWorldResource(User user) {
        this.user = new User();
        this.user.setFirstName(user.getFirstName());
    }

    @GET
    @Path("/name")
    @Produces(MediaType.APPLICATION_JSON)
    public User getName() {

        return user/*.getFirstName()*/;
    }

   public String getUserFirstName(){
        return this.user.getFirstName();
    }
}
