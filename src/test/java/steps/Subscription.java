package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.SubscriptionDetails;
import pojo.Subscriptions;
import pojo.UserSub;
import utilities.BaseUtility;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Subscription {
    public static ResponseOptions<Response> respose;
    public static String token = "token";
    public static String userSub = null;

    @Given("Given user call {string} https request for {string} with origin and destination stop")
    public void givenUserCallHttpsRequestForWithOriginAndDestinationStop(String get, String uri, DataTable table) throws IOException {
        var data = table.cells();
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put( "origin_stop_id", data.get( 1 ).get( 0 ) );
        queryParams.put( "destination_stop_id", data.get( 1 ).get( 1 ) );
        BaseUtility util = new BaseUtility( get, uri, token );
        respose = util.HitApiWithQueryParams( queryParams );
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

    @Then("I should see the subscription details in the API response as below")
    public void iShouldSeeTheSubscriptionDetailsInTheAPIResponseAsBelow(DataTable table) {
        var data = table.cells();
        var subscriptionResponse = respose.getBody().as( SubscriptionDetails.class );
        assertThat( subscriptionResponse.data.getCta(), equalTo( data.get( 1 ).get( 0 ) ) );
        assertThat( subscriptionResponse.getData().subscription_details.getAmount(), equalTo( data.get( 1 ).get( 1 ) ) );
        assertThat( subscriptionResponse.getData().subscription_details.getRides_count(), equalTo( data.get( 1 ).get( 2 ) ) );
        assertThat( subscriptionResponse.getData().subscription_details.getValidity_days(), equalTo( data.get( 1 ).get( 3 ) ) );
        assertThat( subscriptionResponse.getData().od.from_stop.getId(), equalTo( data.get( 1 ).get( 4 ) ) );
        assertThat( subscriptionResponse.getData().od.to_stop.getId(), equalTo( data.get( 1 ).get( 5 ) ) );
    }

    @Given("Given user call {string} https request for {string} for selected subscription")
    public void givenUserCallHttpsRequestForForSelectedSubscription(String get, String uri, DataTable table) throws IOException {
        var data = table.cells();
        HashMap<String, Object> body = new HashMap<>();
        body.put( "fromId", data.get( 1 ).get( 0 ) );
        body.put( "subscriptionId", data.get( 1 ).get( 1 ) );
        body.put( "toId", data.get( 1 ).get( 2 ) );
        body.put( "twoWay", Boolean.parseBoolean( data.get( 1 ).get( 2 ) ) );
        BaseUtility util = new BaseUtility( get, uri, token );
        respose = util.HitApiWithBody( body );

    }

    @When("User call {string} https request for {string} for shuttl wallet")
    public void userCallHttpsRequestForForShuttlWallet(String get, String uri, DataTable table) throws IOException {
        var data = table.cells();
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put( "wallet", data.get( 1 ).get( 0 ) );
        BaseUtility util = new BaseUtility( get, uri, token );
        respose = util.HitApiWithQueryParams( queryParams );
    }

    @And("User call {string} https request for {string} with body")
    public void userCallHttpsRequestForWithBody(String post, String uri, DataTable table) throws IOException {
        var data = table.cells();
        HashMap<String, Object> body = new HashMap<>();
        body.put( "bookType", data.get( 1 ).get( 0 ) );
        body.put( "deductShuttlCashback", Boolean.parseBoolean( data.get( 1 ).get( 1 ) ) );
        body.put( "email", data.get( 1 ).get( 2 ) );
        body.put( "fromId", data.get( 1 ).get( 3 ) );
        body.put( "onlyAddOn", Boolean.parseBoolean( data.get( 1 ).get( 4 ) ) );
        body.put( "paymentViaShuttlWallet", data.get( 1 ).get( 5 ) );
        body.put( "selectTimeEnabled", Boolean.parseBoolean( data.get( 1 ).get( 6 ) ) );
        body.put( "subscriptionId", data.get( 1 ).get( 7 ) );
        body.put( "toId", data.get( 1 ).get( 8 ) );
        body.put( "twoWay", Boolean.parseBoolean( data.get( 1 ).get( 9 ) ) );
        body.put( "userFromLat", data.get( 1 ).get( 10 ) );
        body.put( "userFromLng", data.get( 1 ).get( 11 ) );
        body.put( "userFromName", data.get( 1 ).get( 12 ) );
        body.put( "userToLat", data.get( 1 ).get( 13 ) );
        body.put( "userToLng", data.get( 1 ).get( 14 ) );
        body.put( "userToName", data.get( 1 ).get( 15 ) );
        body.put( "wallet", data.get( 1 ).get( 16 ) );
        BaseUtility util = new BaseUtility( post, uri, token );
        respose = util.HitApiWithBody( body );

    }

    @Then("I should see the message {string} in response")
    public void iShouldSeeTheMessageInResponse(String message) {
        assertThat( respose.getBody().jsonPath().get( "data.message" ), equalTo( message ) );
    }

    @Given("User call {string} https request for {string}")
    public void userCallHttpsRequestFor(String get, String uri) throws IOException {
        BaseUtility util = new BaseUtility( get, uri, token );
        respose = util.HitApi();
        userSub = respose.getBody().jsonPath().get( "data.passes[0].pass.user_subscription_id" );

    }

    @Given("User call {string} https request for {string} with userSubscription")
    public void userCallHttpsRequestForWithUserSubscription(String get, String uri) throws IOException {
        BaseUtility util = new BaseUtility( get, uri + userSub, token );
        respose = util.HitApi();
    }

    @Then("I should see the userSubscription details as below in API response")
    public void iShouldSeeTheUserSubscriptionDetailsAsBelowInAPIResponse(DataTable table) {
        var data = table.cells();
        var UserSubResponse = respose.getBody().as( UserSub.class );
        assertThat( UserSubResponse.getData().getCta(), equalTo( data.get( 1 ).get( 0 ) ) );
        assertThat( UserSubResponse.getData().od.from_stop.getName(), equalTo( data.get( 1 ).get( 1 ) ) );
        assertThat( UserSubResponse.getData().od.to_stop.getName(), equalTo( data.get( 1 ).get( 2 ) ) );
        assertThat( UserSubResponse.getData().getSub_cta(), equalTo( data.get( 1 ).get( 3 ) ) );
        assertThat( UserSubResponse.getData().getSubscription_details().getApplicability(),equalTo(data.get( 1 ).get( 4 )));
        assertThat( UserSubResponse.getData().getSubscription_details().getRenewable(), equalTo(Boolean.parseBoolean(data.get( 1 ).get( 5 ) )));
        assertThat( UserSubResponse.getData().getSubscription_details().getState(), equalTo( data.get( 1 ).get( 6 ) ) );
        assertThat( UserSubResponse.getData().getSubscription_details().getSubscription_id(), equalTo( data.get( 1 ).get( 7 ) ) );
        assertThat( UserSubResponse.getData().getUser_subscription_details().get(0).getValue(), equalTo( data.get( 1 ).get( 8 ) ) );
    }

    @Given("User call {string} https request for {string} with query params as userSubscription")
    public void userCallHttpsRequestForWithQueryParamsAsUserSubscription(String get, String uri) throws IOException {
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put( "userSubscriptionId",userSub );
        BaseUtility util = new BaseUtility( get, uri, token );
        respose = util.HitApiWithQueryParams( queryParams );

    }

    @Given("User call {string} https request for {string} with userSubscription & reasonid")
    public void userCallHttpsRequestForWithUserSubscriptionReasonid(String post, String uri) throws IOException {
        HashMap<String, Object> refundBody = new HashMap<>();
        refundBody.put( "reasonId",Integer.parseInt( "6" ) );
        refundBody.put( "userSubscriptionId",userSub );
        BaseUtility util = new BaseUtility( post, uri, token );
        respose = util.HitApiWithBody( refundBody );
        respose.getBody().jsonPath().prettyPrint();

    }

    @Then("I should see the refund success message {string} in response")
    public void iShouldSeeTheRefundSuccessMessageInResponse(String refundMessage) {
        assertThat( respose.getBody().jsonPath().getString("data.message"),equalTo(refundMessage));
    }
}
