package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.runner.RunWith;
import pojo.LoginBody;
import pojo.OtpBody;
import pojo.RegisterBody;
import utilities.BaseUtility;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Cucumber.class)
public class login {
    public static ResponseOptions<Response> respose;
    public static String token = null;

    @Given("Given user call {string} https request for {string} with {string} and {string} and {string} body")
    public void givenUserCallHttpsRequestForWithAndAndBody(String post, String uri, String newDevice, String phoneNumber, String policyPerused) throws IOException {
        OtpBody otpBody = new OtpBody();
        otpBody.setNewDevice( Boolean.parseBoolean( newDevice ) );
        otpBody.setPhoneNumber( phoneNumber );
        otpBody.setPolicyPerused( Boolean.parseBoolean( policyPerused ) );
        BaseUtility util = new BaseUtility( post, uri, null );
        respose = util.HitApiWithBody( otpBody );
        // respose = BaseUtil.GenerateOtpWithBody( url, otpBody );
    }

    @Given("Given user call {string} https request for {string} with {string} and {string} and {string} and {string} and {string} and {string} body")
    public static void given_user_call_https_request_for_with_and_and_and_and_and_body(String post, String uri, String loginType, String newDevice, String newUser, String otp, String phoneNumber, String policyPerused) throws IOException {
        LoginBody loginBody = new LoginBody();
        loginBody.setLoginType( loginType );
        loginBody.setNewDevice( Boolean.parseBoolean( newDevice ) );
        loginBody.setNewUser( Boolean.parseBoolean( newUser ) );
        loginBody.setOtp( otp );
        loginBody.setPhoneNumber( phoneNumber );
        loginBody.setPolicyPerused( Boolean.parseBoolean( policyPerused ) );
        BaseUtility util = new BaseUtility( post, uri, null );
        token = util.getUserSession( loginBody );
        //respose = BaseUtil.LoginWithBodyAndHeader( url, loginBody );
    }

    @Given("user call {string} https request for {string} with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_call_https_request_for_with_and_and_and_and_and_and_and_and(String post, String uri, String email, String gender, String homeLat, String homeLng, String homeLocation, String name, String workLat, String workLng, String workLocation) throws IOException {
        RegisterBody registerBody = new RegisterBody();
        registerBody.setEmail( email );
        registerBody.setGender( gender );
        registerBody.setHomeLat( Float.parseFloat( homeLat ) );
        registerBody.setHomeLng( Float.parseFloat( homeLng ) );
        registerBody.setHomeLocation( homeLocation );
        registerBody.setName( name );
        registerBody.setWorkLat( Float.parseFloat( workLat ) );
        registerBody.setWorkLng( Float.parseFloat( workLng ) );
        registerBody.setWorkLocation( workLocation );
        BaseUtility util = new BaseUtility( post, uri, token );
        respose = util.HitApiWithBodyAndHeader( registerBody );
    }

    @Then("I should see the success key value as {string} in the API response")
    public void iShouldSeeTheSuccessKeyValueAsInTheAPIResponse(String True) {
        assertThat( respose.getBody().jsonPath().get( "success" ), equalTo( Boolean.parseBoolean( True ) ) );
    }

}

