package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.SearchPreference;
import pojo.SearchPreferenceDataProvider;
import pojo.StopResults;
import utilities.BaseUtility;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StopSearch {
    public static ResponseOptions<Response> response;
    public static String token = "";

    @Given("User call {string} https request for {string} call")
    public void user_call_https_request_for_call(String get, String uri) throws IOException {
        BaseUtility util = new BaseUtility( get, uri, token );
        response = util.HitApi();

    }

    @Then("If search provider name is {string} then triggered value should be {string}")
    public void ifSearchProviderNameIsThenTriggeredValueShouldBe(String expectedSearchProviderName, String expectedTriggeredValue) {
        var placeResponse = response.getBody().as( SearchPreference.class );
        var placePreferenceResponse = placeResponse.getData();
        SearchPreferenceDataProvider searchPreferenceDataProvider = placePreferenceResponse.get( 0 ).getProvider().stream().filter( x -> x.getName().equalsIgnoreCase( expectedSearchProviderName ) )
                .findFirst().orElse( null );
        assertThat( searchPreferenceDataProvider.getTrigger_value(), equalTo( expectedTriggeredValue ) );
    }


    @Given("User call {string} https request for {string} with String {string} and type as {string}")
    public void userCallHttpsRequestForWithStringAndTypeAs(String get, String uri, String keywordString, String typeFromTo) throws IOException {
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put( "keyword", keywordString);
        queryParams.put( "type",typeFromTo);
        BaseUtility util = new BaseUtility( get, uri, token );
        response = util.HitApiWithQueryParams( queryParams );

    }


    @Then("Results should contain {string} and {string}")
    public void resultsShouldContainAnd(String expectedFirstStop, String expectedSecondStop) {
        var stopResultsResponse = response.getBody().as( StopResults.class);
        assertThat( stopResultsResponse.getData().get(0).getName(), equalTo( expectedFirstStop ) );
        assertThat( stopResultsResponse.getData().get(1).getName(), equalTo( expectedSecondStop ) );

    }
}