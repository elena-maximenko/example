import com.fasterxml.jackson.databind.ObjectMapper;
import config.TestConfiguration;
import entity.User;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;
import static org.junit.Assert.assertEquals;

public class HelloWorldApplicationEndPointTest {


    @ClassRule
    public static final DropwizardAppRule<TestConfiguration> RULE =
            new DropwizardAppRule(HelloWorldApplication.class, resourceFilePath("example.yml"));


    @Test
    @Consumes(MediaType.APPLICATION_JSON)
    public void returnsFirstNameFromUrl() throws Exception{
        String expected = "Olena";

        ObjectMapper objectMapper = new ObjectMapper();

        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet("http://localhost:8080/welcome/name");

        // get method request
        HttpResponse httpResponse = defaultHttpClient.execute(httpGet);

        String result = EntityUtils.toString(httpResponse.getEntity());

        User user = objectMapper.readValue(result, User.class);

        assertEquals(expected, user.getFirstName());
    }

}
