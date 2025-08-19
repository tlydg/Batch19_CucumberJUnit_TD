package com.euroTech.pages;


import com.euroTech.utilities.BrowserUtils;
import com.euroTech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

    @FindBy(css ="ol.breadcrumb>li:nth-of-type(2)")
    public WebElement userProfilePageTitle;

    @FindBy(xpath = "//li[@class='breadcrumb-item'][2]")
    public WebElement userProfilePageTitle2;

    @FindBy(css="#profile-overview>div:nth-of-type(1)")
    public WebElement profileUpdateMessage;

    public void navigateUserProfileTabs(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//li//button[text()='"+tabName+"']"));
        tab.click();
    }

    public String lastAddedSchoolName(String schoolName){
      return Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]")).getText();

    }

    public void deleteLastAddedEducationRecord(String schoolName){
        WebElement deleteBtn = Driver.get().findElement(By.xpath("(//span[text()='" + schoolName + "'])[last()]/ancestor::tr//a"));

        BrowserUtils.scrollToElement(deleteBtn);
        BrowserUtils.clickWithJS(deleteBtn);

        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }

    public String lastAddedJobTitle(String jobTitle){
       return Driver.get().findElement(By.xpath("//span[text()='"+jobTitle+"'][last()]")).getText();

    }

    public void deleteLastAddedJobTitleRecord(String jobTitle){
        WebElement jobdeleteBtn = Driver.get().findElement(By.xpath("(//span[text()='" + jobTitle + "'])[last()]/ancestor::tr//a"));

        BrowserUtils.scrollToElement(jobdeleteBtn);
        BrowserUtils.clickWithJS(jobdeleteBtn);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }

    public void verifyLastAddedSchoolRecordWithSchoolName(String schoolName){
        Assert.assertEquals(schoolName, lastAddedSchoolName(schoolName));
    }
}
