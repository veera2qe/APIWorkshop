package com.apiutils;


import com.apiconstants.API_Constants;
import com.fileutils.FileUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPMethods extends FileUtils {
    Logger logger= Logger.getLogger(HTTPMethods.class.getName());

    @Step("Stimulating {0} Request")
    public Response stimulaterequest(String httpMethodCall,Object... apiInputs) {
        logger.log(Level.INFO,"Stimulating {0} request ",new Object[]{httpMethodCall});
        Response response=null;
        try {
            RestAssured.baseURI = API_Constants.BASE_URL.getValue();
            switch (httpMethodCall.toLowerCase()) {
                case "get":
                   response= get(apiInputs);
                    break;
                case "post":
                    response=postOrPut("post",apiInputs);
                    break;
                case "put":
                    response=postOrPut("put",apiInputs);
                    break;
            }
            return response;
        }catch(Exception e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            return response;
        }
    }

    private Response get(Object...apiInputs){
        RequestSpecification requestSpecification=null;
       Response response=null;
        Map<String, String> params = null;
        requestSpecification = RestAssured.given();
        String resources = null;
        if (apiInputs.length > 1) {
            logger.log(Level.INFO,"Configure Parameters");
            params = (Map<String, String>) apiInputs[0];
            for (Map.Entry<String, String> param : params.entrySet()) {
                requestSpecification.params(param.getKey(), param.getValue());
            }
            logger.log(Level.INFO,"Configure Resources {0}",new Object[]{apiInputs[1].toString()});
            resources = apiInputs[1].toString();
        } else {
            logger.log(Level.INFO,"Configure Resources {0}",new Object[]{apiInputs[0].toString()});
            resources = apiInputs[0].toString();
        }
        response= requestSpecification.when().get(API_Constants.valueOf(resources).getValue()).then().extract().response();
        logger.log(Level.INFO,"Get Call Completed ... with status code as {0}  Resposne: {1}  ",new Object[]{response.statusCode(),response.asPrettyString()});
        return response;
    }

    private Response postOrPut(String callType,Object...apiInputs){
        Response response=null;
        RequestSpecification requestSpecification=null;
        requestSpecification = RestAssured.given();
        String resources = null;
        String body = null;
        if (apiInputs.length > 1) {
            body = apiInputs[0].toString();
            resources = apiInputs[1].toString();
            JSONObject payload = getPayload(body);
            requestSpecification.contentType("application/json\r\n").body(payload.toString());

        } else {
            resources = apiInputs[0].toString();
        }
        if(callType.equals("post")){
            response=requestSpecification.post(API_Constants.valueOf(resources).getValue()).then().extract().response();
            logger.log(Level.INFO,"Post call completed , Resposne code : {0} , Response {1}",new Object[]{response.statusCode(),response.asPrettyString()});
        }else {
            response=requestSpecification.put(API_Constants.valueOf(resources).getValue()).then().extract().response();
            logger.log(Level.INFO,"Put call completed , Resposne code : {0} , Response {1}",new Object[]{response.statusCode(),response.asPrettyString()});
        }
        return response;
    }




}
