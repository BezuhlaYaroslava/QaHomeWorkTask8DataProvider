import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.tngtech.java.junit.dataprovider.DataProvider;
import page.HomePage;
import page.SignInPage;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class TestTask8 {

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;

    @DataProvider
    public static Object[][] dataProviderLogin() {
        return new Object[][]{
                {" ", " ", "An email address required."},
                {"byaw", " ", "Invalid email address."},
                {"byaw@ukr.net", " ", "Password is required."},
                {"byaw@ukr.net", "t", "Invalid password."}
        };
    }


    @Before
    public void canBe(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/");
        homePage = new HomePage(driver);
    }
    @Test
    @UseDataProvider("dataProviderLogin")
    public void canOpen(String log, String pass, String expected){
    signInPage = homePage.openSignInPage();
    signInPage.correctAuthorization(log, pass);

    assertEquals(expected, signInPage.getActualResult());
    }
}
