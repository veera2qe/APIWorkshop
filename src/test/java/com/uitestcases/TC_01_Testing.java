package com.uitestcases;

import com.pageaction.HomePage;
import org.testng.annotations.Test;

public class TC_01_Testing {
    @Test
    public void RegisterUser(){
        HomePage homePage=new HomePage();
        homePage.signIN();

    }
}
