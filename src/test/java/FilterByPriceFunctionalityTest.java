import org.example.Locators;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.HomePage;

import java.util.List;
public class FilterByPriceFunctionalityTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setup(){
        super.setup();
        homePage = new HomePage(driver);
    }
    @Test
    public void filterByPriceTest(){
        String query = "pen";
        homePage.search(query);

        String minPrice = "50";
        String maxPrice = "42550";
        homePage.filterSearchResultsByPrice(minPrice,maxPrice);

        String expectedUrl = "https://4u.am/en/product/search?text=pen&max=42550";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Failed to apply price filter.");
        List<WebElement> searchResults = driver.findElements(Locators.searchResults);

        for (WebElement result : searchResults) {
            String price = result.findElement(Locators.productPrice).getText();
            Assert.assertTrue(Integer.parseInt(price) >= Integer.parseInt(minPrice) &&
                            Integer.parseInt(price) <= Integer.parseInt(maxPrice),
                    "Found a product outside the price range.");
        }
    }
}
