package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.BaseUtility;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Profile {
    public static ResponseOptions<Response> response;
    public static String token = "";
    @Given("User call {string} https request for {string} to get is profile details")
    public void user_call_https_request_for_to_get_is_profile_details(String get, String uri) throws IOException {
        BaseUtility util = new BaseUtility( get, uri, token );
        response = util.HitApi();

    }

    @Then("User should see the success key value as {string} in the API response along with below details")
    public void user_should_sAee_the_success_key_value_as_in_the_API_response_along_with_below_details(String expectedSuccessKeyValue, DataTable table) {
        var data = table.cells();
        var profileResponse = response.getBody().as(pojo.Profile.class );
        if(profileResponse.isSuccess()){
            var addresses = profileResponse.getData().addresses;
            var expectedHomeAddress = addresses.stream().filter( x -> x.getAddressType().equalsIgnoreCase( "HOME" ) ).findFirst().get().getAddress();
            assertThat(expectedHomeAddress,equalTo(data.get(1).get(0)));
            var expectedOfficeAddress = addresses.stream().filter( x -> x.getAddressType().equalsIgnoreCase( "WORK" ) ).findFirst().get().getAddress();
            assertThat(expectedOfficeAddress,equalTo(data.get(1).get(1)));

        }

    }
    @Given("User call {string} https request for {string} to update his profile with below details")
    public void user_call_https_request_for_to_update_his_profile_with_below_details(String post, String uri, DataTable table) throws IOException {
        var data = table.cells();
        HashMap<String,Object> updateProfileBody = new HashMap<>();
        updateProfileBody.put("gender",data.get(1).get(0));
        updateProfileBody.put( "name",data.get( 1 ).get( 1));
        BaseUtility util = new BaseUtility( post, uri, token );
        response = util.HitApiWithBodyAndHeader(updateProfileBody);

    }

    @Then("User should see the success key value as {string} in the API response")
    public void user_should_see_the_success_key_value_as_in_the_API_response(String successValue) {
        assertThat(response.getBody().jsonPath().getString("success"),equalTo( successValue ));

    }
}
