package com.dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddtExample {

    private final String BASEURL = "http://opensource.demo.orangehrmlive.com";
    private WebDriver webDriver;


    @BeforeClass
    public void beforeClass(){
       webDriver = new HtmlUnitDriver(true);


    }

    @BeforeMethod
    public void beforeMethod(){
        webDriver.get(BASEURL);

    }


//Data Source
    @DataProvider(name="UserCredentials")
    private Object[][] userCredentials(){

return new Object[][]{

                {"Admin", "", "Password cannot be empty"},
                 {"", "admin", "Username cannot be empty"},
               {"", "", "Username cannot be empty"},
              {"sfs", "dsfdf", "Invalid credentials"}


        };

    }

    @Test(dataProvider = "UserCredentials")

    public void testInvalidUserLogin(CharSequence username, CharSequence password, String expectedMessage){
        webDriver.findElement(By.id("txtUsername")).sendKeys(username);
        webDriver.findElement(By.id("txtPassword")).sendKeys(password);
        webDriver.findElement(By.id("txtPassword")).submit();
        Assert.assertEquals(getErrorMsg(),expectedMessage);



    }


    @Test(dataProvider = "UserCredentials2",dataProviderClass = DataSource.class)

    public void testInvalidUserLogin2(CharSequence username, CharSequence password, String expectedMessage){
        webDriver.findElement(By.id("txtUsername")).sendKeys(username);
        webDriver.findElement(By.id("txtPassword")).sendKeys(password);
        webDriver.findElement(By.id("txtPassword")).submit();
        Assert.assertEquals(getErrorMsg(),expectedMessage);



    }


    private String getErrorMsg(){


        return webDriver.findElement(By.id("spanMessage")).getText();

    }
}
