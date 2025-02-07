package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.N11RegisterPage;

public class N11RegisterSteps {
    private final N11RegisterPage registerPage = new N11RegisterPage();
    private final Faker faker = new Faker();
    private String generatedEmail;
    private String generatedPassword;

    @When("I click on the sign up button")
    public void iClickOnTheSignUpButton() {
        registerPage.clickSignUpButton();
    }

    @And("I enter valid registration details")
    public void iEnterValidRegistrationDetails() {
        // Generate fake data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        generatedEmail = faker.internet().emailAddress();
        generatedPassword = faker.internet().password(8, 20, true, true, true);
        String phoneNumber = faker.numerify("5#########"); // Turkish mobile format

        // Fill the registration form
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(generatedEmail);
        registerPage.enterPassword(generatedPassword);
        registerPage.confirmPassword(generatedPassword);
        registerPage.enterPhoneNumber(phoneNumber);
        registerPage.selectGender("male"); // You can randomize this if needed
        registerPage.acceptTerms();
    }

    @And("I click the register button")
    public void iClickTheRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Then("I should see a registration confirmation")
    public void iShouldSeeARegistrationConfirmation() {
        Assert.assertFalse("Registration should be successful without error message", 
            registerPage.isErrorMessageDisplayed());
    }

    @Then("I should see a registration error message")
    public void iShouldSeeARegistrationErrorMessage() {
        Assert.assertTrue("Error message should be displayed for invalid registration", 
            registerPage.isErrorMessageDisplayed());
    }
}
