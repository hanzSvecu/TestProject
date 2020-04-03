import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createWebDriver(){
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "drivers//geckodriver-windows-64bit.exe");
        this.driver = new FirefoxDriver(options);
    }
}
