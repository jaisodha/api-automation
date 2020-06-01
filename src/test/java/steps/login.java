package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.runner.RunWith;
import pojo.LoginBody;
import pojo.LoginResponse;
import utilities.BaseUtil;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Cucumber.class)
public class login {
    public static ResponseOptions<Response> respose;
    @Given("Given user call {string} https request for {string} with body")
    public void givenUserCallHttpsRequestForWithBody(String post, String url, DataTable table){
        var data = table.cells();
        LoginBody loginBody = new LoginBody();
        loginBody.setLoginType(data.get(1).get(0));
        loginBody.setNewDevice(Boolean.parseBoolean(data.get(1).get(1)));
        loginBody.setNewUser(Boolean.parseBoolean(data.get(1).get(2)));
        loginBody.setOtp(data.get(1).get(3));
        loginBody.setPhoneNumber(data.get(1).get(4));
        loginBody.setPolicyPerused(Boolean.parseBoolean(data.get(1).get(5)));
        respose = BaseUtil.LoginWithBodyAndHeader(url,loginBody);

    }

    @Given("Given user call {string} https request for {string} with {string} and {string} and {string} and {string} and {string} and {string} body")
    public void given_user_call_https_request_for_with_and_and_and_and_and_body(String post, String url, String loginType, String newDevice, String newUser, String otp, String phoneNumber, String policyPerused) {
        LoginBody loginBody = new LoginBody();
        loginBody.setLoginType(loginType);
        loginBody.setNewDevice(Boolean.parseBoolean(newDevice));
        loginBody.setNewUser(Boolean.parseBoolean(newUser));
        loginBody.setOtp(otp);
        loginBody.setPhoneNumber(phoneNumber);
        loginBody.setPolicyPerused(Boolean.parseBoolean(policyPerused));
        respose = BaseUtil.LoginWithBodyAndHeader(url,loginBody);
    }


    @Then("I should see the session token in response with json validations")
    public void iShouldSeeTheSessionTokenInResponseWithJsonValidations() {
        var responseBody = respose.getBody().asString();
        assertThat(responseBody,matchesJsonSchemaInClasspath("loginResponse.json"));
        var loginResponse = respose.getBody().as(LoginResponse.class);
        var session_token = loginResponse.getData().getSessionId();
        System.out.println(session_token);
    }
}

