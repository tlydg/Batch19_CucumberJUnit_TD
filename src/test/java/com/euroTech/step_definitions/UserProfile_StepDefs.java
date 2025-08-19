package com.euroTech.step_definitions;

import com.euroTech.pages.AddEducationPage;
import com.euroTech.pages.AddExperiencePage;
import com.euroTech.pages.UserProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class UserProfile_StepDefs {

    UserProfilePage userProfilePage = new UserProfilePage();
    AddExperiencePage addExperiencePage = new AddExperiencePage();
    AddEducationPage addEducationPage = new AddEducationPage();

    @When("The user navigates user profile tab menu with: {string}")
    public void the_user_navigates_user_profile_tab_menu_with(String tabMenu) {
        userProfilePage.navigateUserProfileTabs(tabMenu);
    }

    @Then("The user should be able to verify add experience form labels with following list")
    public void the_user_should_be_able_to_verify_add_experience_form_labels_with_following_list(List<String> labels) {
        Assert.assertEquals(labels, addExperiencePage.getAddExperienceFormLabelsTexts());
    }

    @Then("The user should be able to verify add education form labels with following list")
    public void the_user_should_be_able_to_verify_add_education_form_labels_with_following_list(List<String> labels) {
      //Assert.assertEquals(labels,addEducationPage.getAdd);

        addEducationPage.verifyAddEducationFormLabels(labels);
    }

    @Then("The user verifies that add education page is displayed")
    public void the_user_verifies_that_add_education_page_is_displayed() {
        addEducationPage.verifyAddEducationPageIsDisplayed();
    }
    @When("The user fills the aducation form with {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_fills_the_aducation_form_with_and_and_and_and_and(String schoolName, String degree, String study, String fromDate, String toDate, String desc) {
            addEducationPage.fillingAddEducationForm(schoolName,degree,study,fromDate,toDate,desc);
    }
    @Then("The user should be able to veriy added education record with {string}")
    public void the_user_should_be_able_to_veriy_added_education_record_with(String schoolName) {
        userProfilePage.verifyLastAddedSchoolRecordWithSchoolName(schoolName);
    }

    @Then("The user should be able to delete last added education record with {string}")
    public void the_user_should_be_able_to_delete_last_added_education_record_with(String schoolName) {
        userProfilePage.deleteLastAddedEducationRecord(schoolName);
    }




}
