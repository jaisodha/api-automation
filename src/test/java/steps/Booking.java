package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.CombinedSlots;
import pojo.RescheduleSlots;
import utilities.BaseUtility;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Booking {
    public static ResponseOptions<Response> response;
    public static String token = "";
    public static String tripId = null;
    public static String boardingTime = null;
    public static String bookingId = null;


    public String getTripId() throws IOException {
        String get = "GET";
        String uri = "/v4/routes/combinedSlots";
        String fromLat = "28.58368506583371";
        String fromLng = "77.21241725488308";
        String toLat = "28.56636061941184";
        String toLng = "77.20755711353199";
        Route route = new Route();
        route.givenUserCallHttpsRequestForWithAndAndAnd( get, uri, fromLat, fromLng, toLat, toLng );
        HashMap<String, Object> queryParams = new HashMap<>();
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
        createBookingBody.put( "couponId", data.get( 1 ).get( 0 ) );
        createBookingBody.put( "fromId", data.get( 1 ).get( 1 ) );
        createBookingBody.put( "toId", data.get( 1 ).get( 2 ) );
        createBookingBody.put( "tripId", getTripId() );
        BaseUtility util = new BaseUtility( post, uri, token );
        response = util.HitApiWithBody( createBookingBody );
    }


    @Then("User should get successful response with message {string}")
    public void userShouldGetSuccessfulResponseWithMessage(String message) {
        assertThat( response.getBody().jsonPath().getString( "data.ride_confirmation_screen.title" ), equalTo( message ) );
    }

    @Given("A user call {string} https request for {string} to fetch all cards")
    public void aUserCallHttpsRequestForToFetchAllCards(String get, String uri) throws IOException {
        BaseUtility util = new BaseUtility( get, uri, token );
        response = util.HitApi();
    }

    @Then("User should get booking card if he has active booking")
    public void userShouldGetBookingCardIfHeHasActiveBooking() {
        boardingTime = response.getBody().jsonPath().getString( "data.sessions_info.sessions[0].cards[0].data.booking.boarding_time");
        bookingId = response.getBody().jsonPath().getString( "data.sessions_info.sessions[0].cards[0].data.booking.id");

        System.out.println(boardingTime);
        System.out.println(bookingId);

    }


    @Given("Given user call {string} https request for {string} with below payload for reschedulable")
    public void givenUserCallHttpsRequestForWithBelowPayloadForReschedulable(String get, String uri, DataTable table) throws IOException {
        var data = table.cells();
        HashMap<String, Object> reschedulePayloadBody = new HashMap<>();
        reschedulePayloadBody.put( "fromLat", data.get( 1 ).get( 0 ) );
        reschedulePayloadBody.put( "fromLng", data.get( 1 ).get( 1 ) );
        reschedulePayloadBody.put( "toLat", data.get( 1 ).get( 2 ) );
        reschedulePayloadBody.put( "toLng", data.get( 1 ).get( 3 ) );
        reschedulePayloadBody.put( "fromLocId", data.get( 1 ).get( 4 ) );
        reschedulePayloadBody.put( "toLocId", data.get( 1 ).get( 5 ) );
        reschedulePayloadBody.put( "routeId", data.get( 1 ).get( 6 ) );
        reschedulePayloadBody.put( "tripId", tripId );
        reschedulePayloadBody.put( "source", "Reschedule_Screen" );
        reschedulePayloadBody.put( "boardingTime", boardingTime );
        BaseUtility util = new BaseUtility( get, uri, token );
        response = util.HitApiWithQueryParams( reschedulePayloadBody );

    }

    @And("User should get a bookable slot")
    public void userShouldGetABookableSlot() {
        var rescheduleSlots = response.getBody().as( RescheduleSlots.class );
        var slotsData = rescheduleSlots.data.getRoutes().get( 0 ).slots;
        for (int i = 0; i < slotsData.size(); i++)
            if (slotsData.get( i ).getOperational()) {
                if (!slotsData.get( i ).getIsCurrentRide()) {
                    tripId = slotsData.get( i ).trip.getId();
                    boardingTime=slotsData.get(i).getStartTime();
                    System.out.println("This should be a different tripId "+tripId);
                    break;
                }
            }

    }

    @And("If user call {string} https request for {string} with reschedule create booking call")
    public void ifUserCallHttpsRequestForWithRescheduleCreateBookingCall(String post, String uri, DataTable table) throws IOException {
        var data = table.cells();
        HashMap<String, Object> rescheduleCreateBookingBody = new HashMap<>();
        rescheduleCreateBookingBody.put( "boardingTime",boardingTime);
        rescheduleCreateBookingBody.put( "bookingId",bookingId);
        rescheduleCreateBookingBody.put( "tripId", tripId);
        rescheduleCreateBookingBody.put( "couponId", data.get( 1 ).get( 0 ) );
        rescheduleCreateBookingBody.put( "fromId", data.get( 1 ).get( 1 ) );
        rescheduleCreateBookingBody.put( "toId", data.get( 1 ).get( 2 ) );
        BaseUtility util = new BaseUtility( post, uri, token );
        response = util.HitApiWithBody(rescheduleCreateBookingBody);



    }

    @Then("User should get successful response with message {string} and parent booking status should be {string}")
    public void userShouldGetSuccessfulResponseWithMessageAndParentBookingStatusShouldBe(String rideConfirmMessage, String parentBookingStatus) {
        assertThat( response.getBody().jsonPath().getString( "data.ride_confirmation_screen.title" ), equalTo( rideConfirmMessage));
        assertThat( response.getBody().jsonPath().getString( "data.parentBookingStatus" ), equalTo( parentBookingStatus));
        bookingId = response.getBody().jsonPath().getString("data.bookingId");
        System.out.println(bookingId);


    }

    @Given("A user call {string} https request for {string} to cancel his ride")
    public void aUserCallHttpsRequestForToCancelHisRide(String post, String uri) throws IOException {
        HashMap<String, Object> cancelBookingBody = new HashMap<>();
        cancelBookingBody.put( "bookingId",bookingId) ;
        cancelBookingBody.put( "reasonId",1 );
        BaseUtility util = new BaseUtility( post, uri, token );
        response = util.HitApiWithBody(cancelBookingBody);
    }

    @Then("User should get his bookingStatus as {string}")
    public void userShouldGetHisBookingStatusAs(String expectedBookingStatus) {
        assertThat( response.getBody().jsonPath().getString( "data.bookingStatus" ), equalTo( expectedBookingStatus));
    }
}
