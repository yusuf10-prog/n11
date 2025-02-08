package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Locale;

public class RegisterPage extends BasePage {
    private final Faker faker = new Faker(new Locale("tr"));
    
    // Locators with multiple possible selectors
    private final By emailInputBy = By.id("registrationEmail");
    private final By passwordInputBy = By.cssSelector("input[type='password'][name='password']");
    private final By nameInputBy = By.id("firstName");
    private final By surnameInputBy = By.id("lastName");
    private final By phoneInputBy = By.id("phoneNumber");
    private final By genderMaleBy = By.cssSelector(".gender-box input[type='radio'], input[name='gender'][value='1']");
    private final By acceptContractBy = By.cssSelector(".contract-box input[type='checkbox'], input[name='acceptContract']");
    private final By acceptReceivePromotionEmailBy = By.cssSelector(".promotional-box input[type='checkbox'], input[name='sendPromotionalEmail']");
    private final By registerButtonBy = By.cssSelector(".btnPrimary.agreement-button, .btnSignup, .btnRegister");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private void debugPageSource() {
        System.out.println("\n=== Current Page Source ===");
        System.out.println(driver.getPageSource());
        System.out.println("=== End Page Source ===");
    }

    public void navigateToRegisterPage() {
        driver.get("https://www.n11.com/uye-ol");
        try {
            try {
                Thread.sleep(5000); // Sayfa yüklenmesi için daha uzun bekleme
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            wait.until(ExpectedConditions.presenceOfElementLocated(emailInputBy));
        } catch (Exception e) {
            System.out.println("Direct registration page not accessible, trying through login page...");
            driver.get("https://www.n11.com/giris-yap");
            try {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                // Kayıt linkini bulmak için birden fazla seçici dene
                List<WebElement> registerLinks = driver.findElements(
                    By.cssSelector("a[href*='uye-ol'], a.btnSignUp, a[title*='ye Ol'], a[class*='register'], a[class*='signup']"));
                
                if (!registerLinks.isEmpty()) {
                    for (WebElement link : registerLinks) {
                        if (link.isDisplayed()) {
                            try {
                                scrollToElement(link);
                                javascriptClick(link);
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ie) {
                                    Thread.currentThread().interrupt();
                                }
                                break;
                            } catch (Exception clickEx) {
                                continue;
                            }
                        }
                    }
                } else {
                    System.out.println("No register link found!");
                }
            } catch (Exception ex) {
                System.out.println("Failed to navigate to registration page: " + ex.getMessage());
                throw ex;
            }
        }
    }

    public void registerWithFakeData() throws InterruptedException {
        debugPageSource(); // Debug için sayfa kaynağını yazdır
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 20, true, true, true);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phone = "5" + faker.number().digits(9); // Turkish mobile number format

        // Wait for form to be interactive and retry if needed
        int maxRetries = 3;
        int retryCount = 0;
        boolean formFound = false;
        
        while (!formFound && retryCount < maxRetries) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(emailInputBy));
                formFound = true;
            } catch (TimeoutException e) {
                System.out.println("Retry " + (retryCount + 1) + ": Waiting for form to load...");
                Thread.sleep(2000);
                retryCount++;
                if (retryCount == maxRetries) {
                    throw new RuntimeException("Form not found after " + maxRetries + " retries");
                }
            }
        }
        
        // Fill in the form with retries for each field
        fillFormField(emailInputBy, email, "email");
        fillFormField(passwordInputBy, password, "password");
        fillFormField(nameInputBy, firstName, "first name");
        fillFormField(surnameInputBy, lastName, "last name");
        fillFormField(phoneInputBy, phone, "phone");
        
        // Handle gender selection
        try {
            WebElement genderElement = wait.until(ExpectedConditions.presenceOfElementLocated(genderMaleBy));
            scrollToElement(genderElement);
            javascriptClick(genderElement);
        } catch (Exception e) {
            System.out.println("Gender selection skipped: " + e.getMessage());
        }
        
        // Handle agreements with retries
        handleCheckbox(acceptContractBy, "contract agreement");
        handleCheckbox(acceptReceivePromotionEmailBy, "promotional emails");
        
        // Find and click submit button
        try {
            // Try to find the button with different approaches
            List<WebElement> buttons = driver.findElements(registerButtonBy);
            boolean buttonClicked = false;
            
            for (WebElement button : buttons) {
                if (button.isDisplayed()) {
                    try {
                        scrollToElement(button);
                        javascriptClick(button);
                        buttonClicked = true;
                        break;
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            
            if (!buttonClicked) {
                // Try finding by different text contents if CSS selectors failed
                String[] buttonTexts = {"Üye Ol", "Kayıt Ol", "Kaydol", "Sign Up", "Register"};
                for (String text : buttonTexts) {
                    try {
                        By buttonXPath = By.xpath(String.format("//button[contains(text(),'%s')] | //input[@value='%s']", text, text));
                        WebElement button = driver.findElement(buttonXPath);
                        if (button.isDisplayed()) {
                            scrollToElement(button);
                            javascriptClick(button);
                            buttonClicked = true;
                            break;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            
            if (!buttonClicked) {
                throw new RuntimeException("Could not find or click the register button");
            }
        } catch (Exception e) {
            System.out.println("Error submitting form: " + e.getMessage());
            throw e;
        }

        // Print the generated credentials for reference
        System.out.println("Generated Test Account:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phone);
    }
    
    private void fillFormField(By locator, String value, String fieldName) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            scrollToElement(element);
            element.clear();
            sendKeys(element, value);
        } catch (Exception e) {
            System.out.println("Error filling " + fieldName + ": " + e.getMessage());
            throw e;
        }
    }
    
    private void handleCheckbox(By locator, String checkboxName) {
        try {
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            scrollToElement(checkbox);
            if (!checkbox.isSelected()) {
                javascriptClick(checkbox);
            }
        } catch (Exception e) {
            System.out.println("Error handling " + checkboxName + " checkbox: " + e.getMessage());
        }
    }
}
