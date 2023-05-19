import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.HomePage;
import org.example.Locators;
import org.openqa.selenium.WebElement;

public class AddToBagFunctionalityTest extends BaseTest {
    private HomePage homePage;
    @BeforeMethod
    public void setup(){
        super.setup();
        homePage = new HomePage(driver);
    }

    @Test
    public void addToBagTest(){
        WebElement product = driver.findElement(Locators.product);
        product.click();

        homePage.addToBag();
        String expectedBagCount = "1";
        String actualBagCount = driver.findElement(Locators.bagCount).getText();
        Assert.assertEquals(actualBagCount, expectedBagCount, "Failed to add the product to the bag.");
    }
}
