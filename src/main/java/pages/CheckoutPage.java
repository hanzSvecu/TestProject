package pages;

import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.waitForElementToDisplay;
import static org.junit.Assert.assertTrue;

public class CheckoutPage extends WebPage {

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/h1")
    private WebElement checkoutPageTitle;

    @Override
    public void open(Object... arguments) {
        assertIsOpen();
    }
    // validates that the name of the searched items is present in number of items found
    @Override
    public void assertIsOpen(Object... arguments) {
        waitForElementToDisplay(checkoutPageTitle);
        assertTrue(checkoutPageTitle.getText().contains("Checkout"));
    }
}
