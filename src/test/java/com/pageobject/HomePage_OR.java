package com.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR extends PageIntiation{
    @FindBy(xpath = "//a[normalize-space(text())='Sign in']")
    public WebElement sign_in;
}
