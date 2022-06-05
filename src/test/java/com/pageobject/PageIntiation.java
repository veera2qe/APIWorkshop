package com.pageobject;

import com.genericmethods.GenricMethods;
import org.openqa.selenium.support.PageFactory;

public class PageIntiation extends GenricMethods {
    public PageIntiation(){
        PageFactory.initElements(driver,this);
    }

}
