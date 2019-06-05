package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import org.junit.Assert;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MyStepdefs {

    private String json;
    private String jsonResponse = "{\n" +
            "  \"userId\": 1,\n" +
            "  \"id\": 1,\n" +
            "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
            "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "}";

    private String URI ="https://jsonplaceholder.typicode.com/";

    private String endpoint;

    private String jsonPostRequest ="{\n" +
            "      title: 'john',\n" +
            "      body: 'warwick',\n" +
            "      userId: 1\n" +
            "    }";

    private String createdRecord;


    private String jsonPostRequestmalformed ="{\n" +
            "      title: 'john',\n" +
            "    }";

    private String malformedResponse;




    @Given("^I use the api \"([^\"]*)\"$")
    public void iUseTheApi(String arg0) throws Throwable {
        endpoint = URI + arg0;
    }

    @When("^I Get the response$")
    public void iGetTheResponse() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(endpoint, String.class);
        json = result;
        System.out.print(result);
    }

    @Then("^The response is equal to json response$")
    public void theResponseIsEqualToJsonResponse() {
        Assert.assertTrue(json.contentEquals(jsonResponse));
    }


    // -------------------Scenario 2 Step Defs ------------------
    @Given("^I use the end point \"([^\"]*)\"$")
    public void iUseTheEndPoint(String arg0) throws Throwable {
        endpoint = URI + arg0;
     }

    @When("^I post the data$")
    public void iPostTheData() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(endpoint, jsonPostRequest, String.class);
        createdRecord = result;
        System.out.print(result);


        // the response should contain the following JSON attributes
        Assert.assertTrue(result.contains("id"));
        Assert.assertTrue(result.contains("title"));
        Assert.assertTrue(result.contains("body"));
        Assert.assertTrue(result.contains("userId"));
    }

    @Then("^I can retrieve the object just created$")
    public void iCanRetrieveTheObjectJustCreated() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts?userId=1", String.class);
        System.out.print(result);

        Assert.assertTrue(result.contains(":john"));
        Assert.assertTrue(result.contains(":warwick"));
    }


    // -------------------------- scenario 3 --------------------------
    @Given("^I use the endpoint \"([^\"]*)\"$")
    public void iUseTheEndpoint(String arg0) throws Throwable {
        endpoint = URI + arg0;
    }

    @When("^I use malformed JSON$")
    public void iUseMalformedJSON() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(endpoint, jsonPostRequestmalformed, String.class);
        malformedResponse = result;
        System.out.print(result);
    }

    @Then("^I should receive an error$")
    public void iShouldReceiveAnError() {
        Assert.assertTrue(malformedResponse.contains("404"));
    }
}
