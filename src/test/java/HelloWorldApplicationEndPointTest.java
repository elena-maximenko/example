import config.TestConfiguration;
import entity.User;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.junit.ResourceTestRule;
import javafx.collections.transformation.SortedList;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import resource.HelloWorldResource;
import sun.jvm.hotspot.HelloWorld;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;
import static org.junit.Assert.assertEquals;

public class HelloWorldApplicationEndPointTest {


    @ClassRule
    public static final DropwizardAppRule<TestConfiguration> RULE =
            new DropwizardAppRule(HelloWorldApplication.class, resourceFilePath("example.yml"));

    /*@Rule unsatisfied dependency injection
    public ResourceTestRule resource = ResourceTestRule.builder()
            .addResource(new HelloWorldResource()).build();*/


    @Test
    @Consumes(MediaType.APPLICATION_JSON)
    public void returnsFirstNameFromUrl() throws Exception{
        String expected = "Olena";
        //Obtain client from @Rule.
        /*Client client = ClientBuilder.newClient();
        //Get WebTarget from client using URI of root resource.
        WebTarget helloTarget = client.target("http://localhost:8080/welcome/name");
        //To invoke response we use Invocation.Builder
        //and specify the media type of representation asked from resource.
        Invocation.Builder builder = helloTarget.request(MediaType.APPLICATION_JSON);
        //Obtain response.*/

        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://localhost:8080/welcome/name");
        HttpResponse httpResponse = defaultHttpClient.execute(httpGet);

        String result = EntityUtils.toString(httpResponse.getEntity());

        System.out.println("result = "  +result);

       // Response response = builder.get();
        //System.out.println("entity = " + EntityUtils.toString(response.));

        //System.out.println("responce = " + response);

        //Do assertions.
       // //assertEquals(Response.Status.OK, response.getStatusInfo());
       // String actual = response.readEntity(String.class);
      //  assertEquals(expected, actual);
    }

}
