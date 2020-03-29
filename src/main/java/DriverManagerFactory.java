public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;

        // TODO: add more browsers
        if (type == DriverType.CHROME) driverManager = new ChromeDriverManager();
        else if (type == DriverType.FIREFOX) driverManager = new FirefoxDriverManager();
        else driverManager = new ChromeDriverManager();

        return driverManager;
    }

}
