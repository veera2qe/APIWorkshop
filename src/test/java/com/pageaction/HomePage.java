package com.pageaction;

import com.genericmethods.GenricMethods;
import com.pageobject.HomePage_OR;
import com.pageobject.PageIntiation;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GenricMethods {
    HomePage_OR homePage_or=new HomePage_OR();
    public void signIN(){
        clickElement("Home Page","Signin",homePage_or.sign_in);
        getScreenshot();
    }

}
