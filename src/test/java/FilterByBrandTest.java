import org.example.HomePage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;
import java.util.List;

public class FilterByBrandTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setup(){
        super.setup();
        homePage = new HomePage(driver);
    }

    @Test
    public void filterBySingleBrandTest() {
        homePage.openUrl("https://4u.am/en");

        String brandName = "Kara Silver";

        homePage.selectBrandFilterCheckbox(brandName);

        List<WebElement> products = homePage.getDisplayedProducts();

        for (WebElement product : products) {
            String productBrand = homePage.getProductBrand(product);
            Assertions.assertEquals(brandName, "Found product of another brand!", productBrand);
        }
    }

    @Test
    public void filterByTwoBrandsTest() {
        homePage.openUrl("https://4u.am/en");

        List<String> brandNames = Arrays.asList("SiaMoods", "Kara Silver");

        for (String brandName : brandNames) {
            homePage.selectBrandFilterCheckbox(brandName);
        }
        List<WebElement> products = homePage.getDisplayedProducts();
        for (WebElement product : products) {
            String productBrand = homePage.getProductBrand(product);
            Assert.assertTrue("Found product of another brand!", brandNames.contains(productBrand));
        }
    }
}
