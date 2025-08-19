package com.euroTech.pages;


import com.euroTech.utilities.BrowserUtils;
import com.euroTech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddEducationPage extends BasePage{

    @FindBy(xpath = "//div/button[text()='Add Education']")
    public WebElement addEducationBtn;

    @FindBy(id="school")
    public WebElement schoolBox;

    @FindBy(id="todateedu")
    public WebElement toDateBox;

    @FindBy(xpath="(//textarea[@id='description'])[2]")
    public WebElement descriptionBox;

    @FindBy(xpath = "//div[@id='education-add']//form//label[not(@for='current')]")
    public List<WebElement> educationFormLabels;

    public void fillingAddEducationForm(String schoolName, String degree,String study,String fromDate,
                                        String toDate,String desc){
        Actions actions = new Actions(Driver.get());

        actions.click(schoolBox)
                .sendKeys(schoolName+ Keys.TAB)
                .sendKeys(degree+Keys.TAB)
                .sendKeys(study + Keys.TAB)
                .sendKeys(fromDate+Keys.TAB+Keys.TAB).perform();
                 toDateBox.sendKeys(toDate);
                 actions.click(descriptionBox)
                .sendKeys(desc+Keys.TAB+Keys.ENTER).perform();
    }

    public List<String> getAddEducationFormLabelsTexts(){
        BrowserUtils.waitForVisibility(addEducationBtn,10);
        return BrowserUtils.getElementsText(educationFormLabels);
    }

    public void verifyAddEducationFormLabels(List<String> expectedLabels){
        Assert.assertEquals(expectedLabels, getAddEducationFormLabelsTexts());
    }

    public void verifyAddEducationPageIsDisplayed() {
        Assert.assertTrue(BrowserUtils.waitForVisibility(addEducationBtn,10).isDisplayed());
    }


}
