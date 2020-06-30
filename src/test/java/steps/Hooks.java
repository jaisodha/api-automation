package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseUtil;

import java.io.IOException;

public class Hooks {
    @Before(order = 1)
    public void TestSetup() throws IOException {
        BaseUtil baseUtil = new BaseUtil();

    }
    @Before(order = 2,value = "@booking")
    public void before(Scenario scenario) throws IOException {
        String post = "post";
        String url = "/v3/auth/user";
        String loginType = "SHUTTL";
        String newDevice = "true";
        String newUser = "true";
        String otp = "1337";
        String phoneNumber ="9555814581";
        String policyPerused = "true";
        System.out.println("---------************-------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("---------************-------");
        login.given_user_call_https_request_for_with_and_and_and_and_and_body(post,url,loginType,newDevice,newUser,otp,phoneNumber,policyPerused);
    }



    @After
    public void after(Scenario scenario){
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("------------------------------------");
    }

}
