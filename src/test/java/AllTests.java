import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllTests extends BaseTest {
    LoginPage loginPage;

    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;


    @BeforeMethod
    public void SetUp() {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);


    }

    @Test
    public void AddCartThreeProducts() {
        loginPage.setUserName("standard_user"); /*nije mi radio poziv na loginpage,pa sam zato ponovo upisao akciju za logovanje na stranu*/
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.sortProduct("Price (low to high)");
        inventoryPage.clickOnesie();
        inventoryPage.clickbikeLight();
        inventoryPage.clickTshirt();
        Assert.assertEquals(inventoryPage.getCartNumber(), "3");

    }

    @Test
    public void removeTwoProuducts() {
        loginPage.setUserName("standard_user"); /*nije mi radio poziv na loginpage,pa sam zato ponovo upisao akciju za logovanje na stranu*/
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.clickOnesie();
        inventoryPage.clickbikeLight();
        inventoryPage.clickCart();
        inventoryPage.removeBikelight();
        inventoryPage.removeOnesie();
        Assert.assertEquals(inventoryPage.cartNumber(), "");

    }

    @Test
    public void TotalPrice()
    {

        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.clickOnesie();
        inventoryPage.clickbikeLight();
        inventoryPage.clickTshirt();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.inputPersonalInfo("Milos","Boskovic", "11070");
       Assert.assertEquals(checkoutStepOnePage.getItemTotal(),"Item total: $33.97");
        Assert.assertEquals(checkoutStepOnePage.getTotal(),"Total: $36.69");

     }
     @Test
     public void wholeProcesOfBuyingProducts()
     {
         loginPage.setUserName("standard_user");
         loginPage.setPassword("secret_sauce");
         loginPage.clickLogin();
         inventoryPage.clickOnesie();
         inventoryPage.clickbikeLight();
         inventoryPage.clickTshirt();
         inventoryPage.clickCart();
         cartPage.clickCheckout();
         checkoutStepOnePage.inputPersonalInfo("Milos","Boskovic", "11070");
         checkoutStepOnePage.clickFinish();
         Assert.assertEquals(checkoutStepOnePage.getMessage(),"Thank you for your order!");
     }


    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}

