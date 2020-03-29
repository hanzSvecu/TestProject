import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    DriverManager driverManager;
    WebDriver driver;

    @Test
    public void navigateToEbayTest() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get("https://www.ebay.com");
//        Assert.assertEquals("Electronics, Cars, Fashion, Collectibles & More | eBay", driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("eBay"));
    }

}
