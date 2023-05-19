import org.example.HomePage;
import org.example.Locators;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
public class SearchFunctionalityTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setup(){
        super.setup();
        homePage = new HomePage(driver);
    }
    @Test
    public void searchTest(){
        String query = "pen";
        homePage.search(query);
        String expectedUrl = "https://4u.am/en/product/search?text=pen&type=";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Failed to load the search results page.");

        List<WebElement> searchResults = driver.findElements(Locators.searchResults);
        boolean queryFoundInResults = false;
        for (WebElement result : searchResults) {
            if (result.getText().toLowerCase().contains(query.toLowerCase())) {
                queryFoundInResults = true;
                break;
            }
        }
        Assert.assertTrue(queryFoundInResults, "The query was not found in the search results.");

        List<WebElement> noResultsMessages = driver.findElements(Locators.noResultsMessage);
        Assert.assertTrue(noResultsMessages.isEmpty(), "A 'no results found' message was displayed.");
    }

}

