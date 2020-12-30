package ClientRest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Callable;

public class ReportTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        ClientConfig cf = new ClientConfig();
        ClientBuilder.newBuilder();
        Client c = ClientBuilder.newClient(cf);
        WebTarget target = c.target("https://free.currconv.com/api/v7/convert?q=ZWL_EUR&compact=ultra&apiKey=9a24447e9d9caf7e2111");
        Invocation.Builder invocationBuilder = target.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();
        JsonObject jsonObject = new JsonParser().parse(response.readEntity(String.class)).getAsJsonObject();
        return ""+jsonObject.get("ZWL_EUR").getAsFloat() ;
    }
}
