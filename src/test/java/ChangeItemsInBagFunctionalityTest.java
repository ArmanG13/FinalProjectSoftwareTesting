import org.example.Locators;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.HomePage;

import static org.example.Locators.product;

public class ChangeItemsInBagFunctionalityTest extends BaseTest {
    private HomePage homePage;
    @BeforeMethod
    public void setup(){
        super.setup();
        homePage = new HomePage(driver);
    }
    @Test
    public void changeItemsInBagTest(){
        String productId = String.valueOf(product);
        homePage.addToBag();

        String expectedBagCount = "1";
        String actualBagCount = driver.findElement(Locators.bagCount).getText();
        Assert.assertEquals(actualBagCount, expectedBagCount, "Failed to add the product to the bag.");

        for(int i=0;i<2;i++) {
            homePage.addToBag();
        }
        String newQuantity = "3";
        homePage.changeItemQuantityInBag(newQuantity);

        String actualProductQuantity = driver.findElement(Locators.productQuantityInBag(productId)).getText();
        Assert.assertEquals(actualProductQuantity, newQuantity, "Failed to update the product quantity in the bag.");
    }
    @Test
    public void removeFromBagTest() {


        String expectedBagCount = "3";
        String actualBagCount = driver.findElement(Locators.bagCount).getText();
        Assert.assertEquals(actualBagCount, expectedBagCount, "Failed to add items to the bag.");

        homePage.removeFromBag();

        String expectedUpdatedBagCount = "2";
        String actualUpdatedBagCount = driver.findElement(Locators.bagCount).getText();
        Assert.assertEquals(actualUpdatedBagCount, expectedUpdatedBagCount, "Failed to remove item from the bag.");
    }
}
