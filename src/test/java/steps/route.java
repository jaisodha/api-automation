package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.runner.RunWith;
import pojo.CombinedSlots;
import utilities.BaseUtility;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Cucumber.class)
public class Route {
    public static ResponseOptions<Response> response;
    public static String token = "";

    @Given("Given user call {string} https request for {string} with {string} and {string} and {string} and {string}")
    public void givenUserCallHttpsRequestForWithAndAndAnd(String get, String uri, String fromLat, String fromLng, String toLat, String toLng) throws IOException {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put( "fromLat",fromLat );
        queryParams.put( "fromLng",fromLng );
        queryParams.put( "toLat", toLat );
        queryParams.put( "toLng", toLng );
        BaseUtility util = new BaseUtility( get, uri, token );
        response = util.HitApiWithQueryParams( queryParams );
    }

    @And("I should see my pickup point as {string} and drop point as {string}")
    public void iShouldSeeMyPickupPointAsAndDropPointAs(String pickupPoint, String dropPoint) {
        var combinedSlotsResponse = response.getBody().as( CombinedSlots.class );
        var combinedSlotsResponseBody = response.getBody().asString();
        assertThat( combinedSlotsResponseBody, matchesJsonSchemaInClasspath( "CombinedSlots.json" ) );
        assertThat( combinedSlotsResponse.getData().getRoutes().get( 0 ).fromLoc.getName(), equalTo( pickupPoint ) );
        assertThat( combinedSlotsResponse.getData().getRoutes().get( 0 ).toLoc.getName(), equalTo( dropPoint ) );
    }

    @And("If I have any slot operational {string} then I should see slotType {string}.")
    public void ifIHaveAnySlotOperationalThenIShouldSeeSlotType(String operationalValue, String slotType) {
        var combinedSlotsResponse = response.getBody().as( CombinedSlots.class );
        var slotsData = combinedSlotsResponse.getData().getRoutes().get( 0 ).slots;
        for (pojo.slots slotsDatum : slotsData) {
            boolean value = slotsDatum.isOperational();
            if (Boolean.parseBoolean( operationalValue ) == value) {
                var expectedSlotType = slotsDatum.getSlotType();
                assertThat( expectedSlotType, equalTo( slotType ) );
                break;
            }
        }
    }

    @And("user should be having {string} with coupon code as {string}.")
    public void userShouldBeHavingWithCouponCodeAs(String couponType, String couponCode) {
        var combinedSlotsResponse = response.getBody().as( CombinedSlots.class );

        var expectedCouponType = combinedSlotsResponse.getData().getRoutes().get( 0 ).slots.get( 0 ).getCoupon().getCouponDescription();
        assertThat( expectedCouponType, equalTo( couponType ) );

        var expectedCouponCode = combinedSlotsResponse.getData().getRoutes().get( 0 ).slots.get( 0 ).getCoupon().getCouponCode();
        assertThat( expectedCouponCode, equalTo( couponCode ) );


    }
}
