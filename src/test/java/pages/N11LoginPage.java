package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class N11LoginPage extends BasePage {
    private final By signInButton = By.className("btnSignIn");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("loginButton");
    private final By errorMessage = By.className("errorMessage");

    public N11LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton() {
        click(signInButton);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementVisible(errorMessage);
    }
}
