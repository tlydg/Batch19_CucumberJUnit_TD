package com.euroTech.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{


    @FindBy(xpath = "//h2")
    private WebElement userName;

    @FindBy(css = ".breadcrumb>li:nth-of-type(2)")
    private WebElement pageTitleLeftTop;


    public void verifyUserName(String expectedUsername){
        String actualUsername = userName.getText();
        Assert.assertEquals(expectedUsername,actualUsername);
    }


}
