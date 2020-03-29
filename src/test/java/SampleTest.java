import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTest {

    DriverManager driverManager;
    WebDriver driver;

    @BeforeSuite
    public void startSuite() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
    }

    @AfterSuite
    public void endSuite() {
        driverManager.quitWebDriver();
    }

    @Test
    public void navigateToEbayTest() {
        driver.get("https://www.ebay.com");
        Assert.assertTrue(driver.getTitle().contains("eBay"));
    }

    @Test
    public void navigateToEbayTest_2() {
        driver.get("https://www.ebay.com");
        Assert.assertTrue(driver.getTitle().contains("eBay"));
    }

}
