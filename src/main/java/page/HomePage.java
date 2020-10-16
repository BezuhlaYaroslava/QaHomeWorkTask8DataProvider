package page;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){this.driver = driver;}

   private By btnSignInMarket = By.xpath("//a[@class='login']");

    public SignInPage openSignInPage() {
        WebElement element = driver.findElement(btnSignInMarket);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        return new SignInPage(driver);
    }

}
