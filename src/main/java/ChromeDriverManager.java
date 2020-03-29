import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createWebDriver(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        this.driver = new ChromeDriver(options);
    }
}
