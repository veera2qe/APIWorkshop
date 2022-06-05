package com.testcases;

import com.apiutils.HTTPMethods;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class TC_02_CreateUser extends HTTPMethods {
    @Epic("Fruit Shop API Testing")
    @Feature("Categories")
    @Story("US1876")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "testing 2")
    public void  validateCreateUser() throws ParseException {
        Response response=stimulaterequest("post","createuser","CREATE_USER");
        String custid=getJsonValue(response.asString(),"customer_url");
        System.out.println(custid.substring(custid.lastIndexOf("/")+1).trim());
    }
}
