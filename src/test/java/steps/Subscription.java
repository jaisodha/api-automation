package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.Subscriptions;
import utilities.BaseUtil;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Subscription {
    public static ResponseOptions<Response> respose;

    @Given("Given user call {string} https request for {string} with origin and destination stop")
    public void givenUserCallHttpsRequestForWithOriginAndDestinationStop(String get, String url, DataTable table) {
        var data = table.cells();
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put( "origin_stop_id", data.get( 1 ).get( 0 ) );
        pathParams.put( "destination_stop_id", data.get( 1 ).get( 1 ) );
        respose = BaseUtil.GetSubscriptionsWithPathAndHeader( url, pathParams );
    }


    @Then("I should see the all given subscription in the API response")
    public void iShouldSeeTheAllGivenSubscriptionInTheAPIResponse(DataTable table) {
        var data = table.cells();
        var subscriptionsResponse = respose.getBody().as( Subscriptions.class );
        var expectedPassTitle = subscriptionsResponse.getData().sections.get( 0 ).passes.get( 0 ).getTitle();
        assertThat( expectedPassTitle, equalTo( data.get( 1 ).get( 0 ) ) );

        var expectedStandardPassList = subscriptionsResponse.getData().sections.get( 1 ).passes;
        for (int i = 0; i < expectedStandardPassList.size(); i++) {
            if (i == 0) {
                assertThat( expectedStandardPassList.get( i ).getTitle(), equalTo( data.get( 2 ).get( 0 ) ) );
            } else if (i == 1) {
                assertThat( expectedStandardPassList.get( i ).getTitle(), equalTo( data.get( 3 ).get( 0 ) ) );
            } else if (i == 2) {
                assertThat( expectedStandardPassList.get( i ).getTitle(), equalTo( data.get( 4 ).get( 0 ) ) );
            } else if (i == 3) {
                assertThat( expectedStandardPassList.get( i ).getTitle(), equalTo( data.get( 5 ).get( 0 ) ) );
            } else if (i == 4) {
                assertThat( expectedStandardPassList.get( i ).getTitle(), equalTo( data.get( 6 ).get( 0 ) ) );

            }
        }

    }
}
