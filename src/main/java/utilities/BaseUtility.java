package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utilities.BaseUtil.getGlobalValue;

public class BaseUtility {
    static String session_token = null;

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;


    public BaseUtility(String method,String uri, String token) throws IOException {
        this.method = method;
        this.url = getGlobalValue( "consumerBaseUrl" ) + uri;
        if (token != null)
            builder.addHeader( "sessionId", session_token );
    }
    public BaseUtility(String method,String uri, String token, String BaseUrl) throws IOException {
        this.method = method;
        this.url = getGlobalValue( BaseUrl ) + uri;
        if (token != null)
            builder.addHeader( "sessionId", session_token );
    }

    public ResponseOptions<Response> HitApi() {
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType( ContentType.JSON );
        request.spec( requestSpecification ).log().all();

        if (this.method.equalsIgnoreCase( APIConstant.ApiMethod.GET ))
            return request.get( this.url );
        else if (this.method.equalsIgnoreCase( APIConstant.ApiMethod.POST ))
            return request.post( this.url );
        else if (this.method.equalsIgnoreCase( APIConstant.ApiMethod.DELETE ))
            return request.delete( this.url );
        return null;
    }

    public String getUserSession(Object loginBody) {
        builder.setBody( loginBody );
        builder.addHeaders( setHeader());
        return session_token = HitApi().getBody().jsonPath().get( "data.sessionId" );

    }

    public ResponseOptions<Response> HitApiWithPathParams(Map<String, String> pathParams) {
        builder.addPathParams( pathParams );
        return HitApi();

    }

    public ResponseOptions<Response> HitApiWithQueryParams(Map<String, Object> queryParams) {
        builder.addQueryParams( queryParams );
        return HitApi();
    }

    public ResponseOptions<Response> HitApiWithBody(Object Body) {
        builder.setBody( Body );
        return HitApi();
    }

    public ResponseOptions<Response> HitApiWithBodyAndHeader(Object Body) {
        builder.setBody( Body );
        builder.addHeaders( setHeader());
        return HitApi();

    }

    public Map<String, String> setHeader() {
        Map<String, String> headerMap = new HashMap();
        headerMap.put(Constants.PLATFORM,Constants.PLATFORM_VALUE);
        headerMap.put(Constants.DEVICE_VERSION,Constants.DEVICE_VERSION_VALUE);
        headerMap.put(Constants.APP_VERSION,Constants.APP_VERSION_VALUE);
        headerMap.put(Constants.DEVICE_ID,Constants.DEVICE_ID_VALUE);
        return headerMap;
    }

}
