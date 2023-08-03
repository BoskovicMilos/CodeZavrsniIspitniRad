import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class  InventoryPage extends BasePage
{
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement onesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tshirt;


    @FindBy(className = "shopping_cart_badge")
    WebElement cart;


    @FindBy(className = "product_sort_container")
    WebElement sort;

    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement removeOnesie;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikeLight;


    @FindBy(className = "inventory_item_price")
    WebElement price;

    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnesie(){ onesie.click();}
    public void clickbikeLight() {bikeLight.click();}
    public void clickTshirt() {tshirt.click();}
    public String getCartNumber() {return cart.getText();}

    public void removeOnesie(){removeOnesie.click(); }
    public void removeBikelight(){removeBikeLight.click();}


    public String cartNumber () {return cartLink.getText();}

    public void sortProduct(String text)
    {
        Select select = new Select(sort);
        select.selectByVisibleText(text);
    }


    public void clickCart()
    {
        cart.click();
    }
}