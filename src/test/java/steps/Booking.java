package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.CombinedSlots;
import utilities.BaseUtility;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Booking {
    public static ResponseOptions<Response> response;
    public static String token = "";
    public static String tripId = null;

    public String getTripId() throws IOException {
        String get = "GET";
        String uri = "/v4/routes/combinedSlots";
        String fromLat = "28.58368506583371";
        String fromLng = "77.21241725488308";
        String toLat = "28.56636061941184";
        String toLng = "77.20755711353199";
        Route route = new Route();
        route.givenUserCallHttpsRequestForWithAndAndAnd( get,uri, fromLat, fromLng, toLat, toLng );
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put( "fromLat", fromLat );
        queryParams.put( "fromLng", fromLng );
        queryParams.put( "toLat", toLat );
        queryParams.put( "toLng", toLng );
        BaseUtility util = new BaseUtility( get, uri, token );
        response = util.HitApiWithQueryParams( queryParams );
        var combinedSlotsResponse = response.getBody().as( CombinedSlots.class );
        var slotsData = combinedSlotsResponse.getData().getRoutes().get( 0 ).slots;
        for (pojo.slots slotsDatum : slotsData) {
            if (slotsDatum.isOperational()) {
                tripId = slotsDatum.getTrip().getId();
                break;
            }
        }
        return tripId;
    }

    @Given("A user call {string} https request for {string} with")
    public void aUserCallHttpsRequestForWith(String post, String uri, DataTable table) throws IOException {
        var data = table.cells();
        HashMap<String, String> createBookingBody = new HashMap<>();
        createBookingBody.put("couponId",data.get( 1 ).get( 0 ) );
        createBookingBody.put( "fromId",data.get( 1 ).get( 1)  );
        createBookingBody.put( "toId",data.get( 1 ).get( 2)  );
        createBookingBody.put( "tripId",getTripId() );
        BaseUtility util = new BaseUtility( post, uri, token );
        response = util.HitApiWithBody( createBookingBody );
    }


    @Then("User should get successful response with message {string}")
    public void userShouldGetSuccessfulResponseWithMessage(String message) {
    assertThat(response.getBody().jsonPath().getString("data.ride_confirmation_screen.title"),equalTo(message));
    }
}
