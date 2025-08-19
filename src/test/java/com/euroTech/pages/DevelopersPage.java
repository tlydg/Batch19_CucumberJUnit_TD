package com.euroTech.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevelopersPage extends BasePage{

    @FindBy(css = ".breadcrumb>li:nth-of-type(2)")
    private WebElement developersPageTitle;

    public WebElement getDevelopersPageTitle(){
        return developersPageTitle;
    }

    public String getPageTitle(){
        return developersPageTitle.getText();
    }

    public void verifyPageTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle,getPageTitle());
    }




}
