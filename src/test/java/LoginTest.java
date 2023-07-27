import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest  extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp()
    {
        driver = openBrowser();
        loginPage= new LoginPage(driver);
    }
    @Test
    public void logInOnPage ()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public  void loginInvalidUsername()
    {
        loginPage.setUserName("stan");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void loginInvalidPassword()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void loginWithOutPassword()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Password is required");
    }





    @AfterMethod
    public  void after()
    {
        driver.quit();

    }
}
