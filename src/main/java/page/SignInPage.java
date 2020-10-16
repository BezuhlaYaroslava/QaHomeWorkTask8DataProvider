package page;

import authorization.Authorization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    private By loginForm = By.className("login-form");

    private WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement passwordField;
    private WebElement emailField;
    private WebElement createAccountBtn;

    public SignInPage typeEmail(String email){
        emailField = waitOnElement("//input[@id='email']");
        emailField.sendKeys(email);
        return this;
    }
    public SignInPage typePassword(String password){
        passwordField = waitOnElement("//input[@id='passwd']");
        passwordField.sendKeys(password);
        return this;
    }

    public SignInPage clickSignInAccount(){
        createAccountBtn = waitOnElement("//i[@class='icon-lock left']");
        createAccountBtn.click();
        return this;
    }

    private WebElement waitOnElement(String xpath) {
        return (new WebDriverWait(driver, 30)).until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
        );
    }
    public HomePage correctAuthorization(String email, String pass) {

        this.typeEmail(email);
        this.typePassword(pass);
        this.clickSignInAccount();
        return new HomePage(driver);
    }


    public String getActualResult() {
        WebElement element = driver.findElement(By.xpath("//*[@id='center_column']//li"));
        element.getText();
        return element.getText();
    }

}
