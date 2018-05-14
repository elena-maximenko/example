package resource;

import entity.User;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/welcome")
public class HelloWorldResource {

    @Inject
    User user;

    @GET
    @Path("/{key}")
    public String getName(@PathParam("key") String key) {
        return user.getFirstName() + " " + key;
    }
}
