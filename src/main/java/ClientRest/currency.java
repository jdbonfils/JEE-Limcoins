package ClientRest;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.primefaces.shaded.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class currency implements Serializable {


  public static float getLimcoinCurrency(String currency, float limcoins) throws IOException {
    ClientConfig cf = new ClientConfig();
    ClientBuilder.newBuilder();
    Client c = ClientBuilder.newClient(cf);
    WebTarget target = c.target("https://free.currconv.com/api/v7/convert?q=ZWL_" + currency + "&compact=ultra&apiKey=9a24447e9d9caf7e2111");
    Invocation.Builder invocationBuilder = target.request(MediaType.TEXT_PLAIN);
    Response response = invocationBuilder.get();
    JsonObject jsonObject = new JsonParser().parse(response.readEntity(String.class)).getAsJsonObject();
    return (limcoins * jsonObject.get("ZWL_" + currency).getAsFloat());
  }
}
