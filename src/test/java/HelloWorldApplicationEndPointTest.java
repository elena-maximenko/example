import entity.User;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.junit.ResourceTestRule;
import javafx.collections.transformation.SortedList;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import resource.HelloWorldResource;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HelloWorldApplicationEndPointTest {


    @Test
    public void returnsFirstNameFromUrl(){
        String expected = "Olena";
        //Obtain client from @Rule.
        Client client = ClientBuilder.newClient();
        //Get WebTarget from client using URI of root resource.
        WebTarget helloTarget = client.target("http://localhost:8080/welcome/name");
        //To invoke response we use Invocation.Builder
        //and specify the media type of representation asked from resource.
        Invocation.Builder builder = helloTarget.request(MediaType.TEXT_PLAIN);
        //Obtain response.
        Response response = builder.get();

        System.out.println("responce = " + response);

        //Do assertions.
        assertEquals(Response.Status.OK, response.getStatusInfo());
        String actual = response.readEntity(String.class);
        assertEquals(expected, actual);
    }

}
