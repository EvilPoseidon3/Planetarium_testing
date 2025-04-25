package cucumber.functions.steps;

import io.cucumber.java.Before;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static cucumber.functions.steps.RunnerTest.*;

public class Hooks {
    // using the Cucumber Before annotation we can make our method run before each scenario
    @Before
    public void resetDatabase() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/reset"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        client.send(request, HttpResponse.BodyHandlers.ofString());
        loginpage.goToLoginPage();
    }



}
