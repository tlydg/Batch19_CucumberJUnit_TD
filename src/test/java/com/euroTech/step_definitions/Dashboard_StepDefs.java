package com.euroTech.step_definitions;

import com.euroTech.pages.DashboardPage;
import com.euroTech.pages.DevelopersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Dashboard_StepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    DevelopersPage developersPage = new DevelopersPage();

    @When("The user clicks on Developers link")
    public void the_user_clicks_on_developers_link() {
        dashboardPage.navigateToTabs("Developers");
    }
    @Then("The user should be able to see developers' page title")
    public void the_user_should_be_able_to_see_developers_page_title() {
       /*String actualTitle = developersPage.getPageTitle();
       String expectedTitle = "Developers";
       Assert.assertEquals(expectedTitle,actualTitle);

       */
        developersPage.verifyPageTitle("Developers");
        System.out.println("developersPageTitle() = " + developersPage.getDevelopersPageTitle().getText());
    }

    @When("The user click on tab: {string} on module: {string}")
    public void the_user_click_on_tab_on_module(String tabName, String module) {
        dashboardPage.navigateToTabs(tabName,module);
    }
    @Then("The user should be able to see related page title with three parts: {string}")
    public void the_user_should_be_able_to_see_related_page_title_with_three_parts(String pageTitle) {
      Assert.assertEquals(pageTitle,developersPage.getPageTitleWithModule());

    }

    @Then("The user should verify the dashboard tabs with follows")
    public void the_user_should_verify_the_dashboard_tabs_with_follows(List<String > dashboardTabTexts) {
        List<String> actualTabTexts = dashboardPage.getDashboardTabsTexts();
        Assert.assertEquals(dashboardTabTexts,actualTabTexts);

    }

    @Then("The user should be able to see related page title with two parts: {string}")
    public void the_user_should_be_able_to_see_related_page_title_with_two_parts(String expectedTab) {
        String actualTab = dashboardPage.getPageTitleWithTab();
        Assert.assertEquals(expectedTab,actualTab);
    }


}
