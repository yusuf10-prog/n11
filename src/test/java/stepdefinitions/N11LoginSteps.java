package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;
import pages.N11LoginPage;

public class N11LoginSteps {
    private final N11LoginPage loginPage;
    private final Faker faker;

    public N11LoginSteps() {
        loginPage = new N11LoginPage(N11NavigationSteps.getDriver());
        faker = new Faker();
    }

    @When("I click on the sign in button")
    @Step("Clicking sign in button")
    public void iClickOnTheSignInButton() {
        loginPage.clickSignInButton();
    }

    @When("I enter fake email and password")
    @Step("Entering fake credentials")
    public void iEnterFakeEmailAndPassword() {
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password(8, 12, true, true, true);
        
        loginPage.enterEmail(fakeEmail);
        loginPage.enterPassword(fakePassword);
    }

    @When("I click the login button")
    @Step("Clicking login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the error message")
    @Step("Verifying error message")
    public void iShouldSeeTheErrorMessage() {
        Assert.assertTrue("Error message should be displayed", loginPage.isErrorMessageDisplayed());
    }
}
