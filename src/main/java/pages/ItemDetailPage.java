package pages;

import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.waitForElementToDisplay;
import static org.junit.Assert.assertTrue;

public class ItemDetailPage extends WebPage {



    @FindBy(id = "icImg")
    private WebElement picture;
    @FindBy(id = "bb_bdp")
    private WebElement price;
    @FindBy(id = "isCartBtn_btn")
    private WebElement addToCartButton;

    @Override
    public void open(Object... arguments) {
        assertIsOpen();
    }

    // as there is no direct page identifier,
    // I have used following identification of this page:
    // - picture existence
    // - text: Price
    @Override
    public void assertIsOpen(Object... arguments) {
        assertTrue(picture.isDisplayed());
        assertTrue(price.isDisplayed());
    }

    public void addToCart(){
        waitForElementToDisplay(addToCartButton);
        addToCartButton.click();
    }

}
