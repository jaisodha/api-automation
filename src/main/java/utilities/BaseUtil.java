package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;


public class BaseUtil {
    public static RequestSpecification REQUEST;
    public static RequestSpecBuilder REQUEST_BUILDER;
    public static ResponseSpecification RESPONSE;
    public static ResponseSpecBuilder RESPONSE_BUILDER;
    static String session_token = null;

    public BaseUtil() throws IOException {
        REQUEST_BUILDER = new RequestSpecBuilder();
        REQUEST_BUILDER.setBaseUri(getGlobalValue("baseUrl")).setContentType(ContentType.JSON);
        var requestSpec = REQUEST_BUILDER.build();
        REQUEST = RestAssured.given().spec(requestSpec).log().all();

        RESPONSE_BUILDER = new ResponseSpecBuilder();
        RESPONSE_BUILDER.expectStatusCode(200).expectContentType(ContentType.JSON).expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
        var responseSpec = RESPONSE_BUILDER.build();
        RESPONSE = RestAssured.expect().spec(responseSpec).log().all();

    }

    public static ResponseOptions<Response> LoginWithBodyAndHeader(String url, Object loginBody){
        Response response;
        REQUEST.header(new Header("deviceVersion","23"));
        REQUEST.header(new Header( "appVersion","38014"));
        REQUEST.header(new Header( "deviceId","861101033633193"));
        REQUEST.header(new Header( "platform","Android"));

        REQUEST.body(loginBody);
        response= REQUEST.post(url);
        response.then().spec(RESPONSE).log().all();
        session_token = response.getBody().jsonPath().get("data.sessionId");
        return response;
    }

    public static ResponseOptions<Response> GenerateOtpWithBody(String url, Object otpBody){
        Response response;
        REQUEST.body(otpBody);
        response = REQUEST.post(url);
        response.then().spec(RESPONSE);
        return response;

    }
    public static ResponseOptions<Response> GetRouteTimeSlotsWithPathAndHeader(String url, Map<String,String> queryParams){
        Response response;
        REQUEST.header(new Header("sessionId",session_token));
        REQUEST.queryParams(queryParams);
        response = REQUEST.get(url);
        response.then().spec(RESPONSE);
        return response;
    }
    public static ResponseOptions<Response> GetSubscriptionsWithPathAndHeader(String url, Map<String,String> queryParams){
        Response response;
        REQUEST.header(new Header("sessionId",session_token));
        REQUEST.queryParams(queryParams);
        response = REQUEST.get(url);
        response.then().spec(RESPONSE);
        return response;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("/Users/admin/Desktop/restAssured/src/main/resources/global.properties");
        properties.load(file);
        return properties.getProperty(key);

    }



}
