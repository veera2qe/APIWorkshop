package com.uitestcases;

import com.model.WebTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserLaunch {
    @Test
    public void openBrowser() throws InterruptedException {
        List<WebTable> tableData = new ArrayList<>();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String actualUrl = "https://paytm.com/";
        driver.get(actualUrl);
        driver.findElement(By.xpath("//*[text()='Sign In']")).click();
        driver.manage().window().maximize();
        WebDriverWait webDriverWait=new WebDriverWait(driver,35);


        WebElement iFrame=driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iFrame);
String xpath="//span[normalize-space(text())='Watch Video']";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        WebElement watchVideo=driver.findElement(By.xpath(xpath));
        watchVideo.click();
        driver.switchTo().defaultContent();

    }


}

