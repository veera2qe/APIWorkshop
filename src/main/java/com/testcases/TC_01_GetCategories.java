package com.testcases;

import com.apiutils.HTTPMethods;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class TC_01_GetCategories extends HTTPMethods {
    @Epic("Fruit Shop API Testing")
    @Feature("Categories")
    @Story("US12345")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "testing 1")
    public void validateGetCategories(){
        stimulaterequest("get","CATEGORIES");
    }
}
