package com.epam.learn.stepdefs;

import com.epam.learn.pages.AccountCreated;
import com.epam.learn.pages.Home;
import com.epam.learn.pages.Login;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class UserSignupStepDefinition {
    private Home home = new Home();
    private Login login = new Login();
    private AccountCreated accountCreated = new AccountCreated();

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        home.navigateToLoginPage();
    }

    @Given("I enter(ed) the {string} and {string} in the New User Signup on the Login page")
    public void i_entered_the_and_in_the_new_user_signup_on_the_login_page(String name, String email) {
        login.enterUserDetails(name, email);
    }

    @Given("I click(ed) the button Signup in the New User Signup on the Login page")
    public void i_clicked_the_button_signup_in_the_new_user_signup_on_the_login_page() {
        login.clickSignup();
    }

    @When("I enter valid details for a new user on the Signup page")
    public void i_enter_valid_details_for_a_new_user_on_the_signup_page(DataTable dataTable) {
        login.enterUserDetails(dataTable.asMaps().get(0));
    }

    @When("I click the button Create Account on the Signup page")
    public void i_click_the_button_create_account_on_the_signup_page() {
        login.clickCreateAccount();
    }

    @Then("The below confirmation message should be displayed on the Signup page")
    public void the_below_confirmation_message_should_be_displayed_on_the_signup_page(DataTable dataTable) {
        String expectedMessage = accountCreated.getAccountCreatedMessage().trim();
        System.out.println("Expected Message: " + expectedMessage);
        List<String> data = dataTable.asList();
        data.forEach(str -> Assert.assertTrue(expectedMessage.contains(str), "The message '" + str + "' is not present."));
    }

    @Then("The below error message should be displayed just above the Signup button on the Login page")
    public void the_below_error_message_should_be_displayed_just_above_the_signup_button_on_the_login_page(DataTable dataTable) {

    }
}
