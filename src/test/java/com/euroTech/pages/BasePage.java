package com.euroTech.pages;

import com.euroTech.utilities.BrowserUtils;
import com.euroTech.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".breadcrumb>li:nth-of-type(2)")
    private WebElement pageTitleWithTab;

    @FindBy(css = ".breadcrumb>li:nth-of-type(3)")
    private WebElement pageTitleWithModule;

    @FindBy(css = "nav>ul>li")
    private List<WebElement> dashboardTabElements;

    public void navigateToTabs(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='"+tabName+"']"));
        tab.click();
    }

    public void navigateToTabs(String tabName, String moduleName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='"+tabName+"']"));
        tab.click();
       if(!moduleName.isEmpty()) {
           WebElement module = Driver.get().findElement(By.xpath("//span[text()='" + moduleName + "']"));
           module.click();
       }
    }

    public String getPageTitleWithTab(){
        return pageTitleWithTab.getText();
    }

    public String getPageTitleWithModule(){
        return pageTitleWithModule.getText();
    }

    public List<String > getDashboardTabsTexts(){
        return BrowserUtils.getElementsText(dashboardTabElements);
    }


}
