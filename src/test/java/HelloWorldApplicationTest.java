import entity.User;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import resource.HelloWorldResource;

import java.util.ArrayList;
import java.util.List;

public class HelloWorldApplicationTest {

    private List<User> users;
    private HelloWorldResource helloWorldResource;

    @Before
    public void setup(){
        users = new ArrayList<User>(){{
            add(new User("Elen"));
        }};

        helloWorldResource = new HelloWorldResource(users.get(0));


    }

    @Test
    public void firstNameIsNotNull(){
        String firstName = helloWorldResource.getUserFirstName();
        Assert.assertNotNull(firstName);
    }

    @Test
    public void firstNameReturnsFirstElementFromUsers() {
        String firstName = helloWorldResource.getUserFirstName();
        Assert.assertEquals(users.get(0).getFirstName(), firstName);
    }

}
