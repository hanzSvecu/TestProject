public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;

                // TODO: add more browsers

            default:
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;
    }

}
