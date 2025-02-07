package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.n11.utilities.Driver;

public class N11RegisterPage extends BasePage {
    @FindBy(className = "btnSignUp")
    private WebElement signUpButton;

    @FindBy(css = "input[placeholder='Ad']")
    private WebElement firstNameField;

    @FindBy(css = "input[placeholder='Soyad']")
    private WebElement lastNameField;

    @FindBy(css = "input[placeholder='E-posta Adresiniz']")
    private WebElement emailField;

    @FindBy(css = "input[placeholder='Şifre']")
    private WebElement passwordField;

    @FindBy(css = "input[placeholder='Şifre Tekrar']")
    private WebElement confirmPasswordField;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;

    @FindBy(id = "genderMale")
    private WebElement maleGenderRadio;

    @FindBy(id = "genderFemale")
    private WebElement femaleGenderRadio;

    @FindBy(id = "acceptContract")
    private WebElement acceptContractCheckbox;

    @FindBy(id = "acceptContract")
    private WebElement acceptPrivacyPolicyCheckbox;

    @FindBy(id = "submitButton")
    private WebElement registerButton;

    @FindBy(className = "errorMessage")
    private WebElement errorMessage;

    public void clickSignUpButton() {
        signUpButton.click();
        shortWait(); // Wait for registration form to load
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            maleGenderRadio.click();
        } else if (gender.equalsIgnoreCase("female")) {
            femaleGenderRadio.click();
        }
    }

    public void acceptTerms() {
        if (!acceptContractCheckbox.isSelected()) {
            acceptContractCheckbox.click();
        }
        if (!acceptPrivacyPolicyCheckbox.isSelected()) {
            acceptPrivacyPolicyCheckbox.click();
        }
    }

    public void clickRegisterButton() {
        registerButton.click();
        shortWait(); // Wait for registration process
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
