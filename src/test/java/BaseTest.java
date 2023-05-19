import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://4u.am/en/";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @AfterMethod
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
