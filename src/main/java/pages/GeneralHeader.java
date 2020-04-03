package pages;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.github.webdriverextensions.Bot.waitForElementToDisplay;
import static org.junit.Assert.*;

public class GeneralHeader extends WebPage {

    private WebDriver driver = WebDriverExtensionsContext.getDriver();
    private final String cartContainsId = "gh-cart-n";

    @FindBy(id = "gh-shipto-click")
    private WebElement shipToButton;

    @FindBy(id = cartContainsId)
    private WebElement cartContains;

    // this is kind of hack to access non-existing element from parent
    @FindBy(xpath = "//*[@id=\"gh-minicart-hover\"]/div/a[1]")
    private WebElement cartContainsParent;

    @Override
    public void open(Object... arguments) {
        assertIsOpen();
    }
    // validates that all used elements exist
    @Override
    public void assertIsOpen(Object... arguments) {
        assertTrue(shipToButton.isDisplayed());
        assertTrue(cartContains.isDisplayed());
    }

    // as there is no element that would indicate that nothing is in cart, we need too attempt to load non-existing
    // element into List and validate that the list is empty
    public void validateCartIsEmpty(){
        List<WebElement> numberElements = cartContainsParent.findElements(By.id(cartContainsId));
        assertEquals(0,numberElements.size());
    }

    public void validateCartContainsItems(int itemCount){
        int found = getNumberOfItemsInCart();
        assertEquals(itemCount, found);
    }

    public int getNumberOfItemsInCart() {
//        driver.navigate().refresh();
        waitForElementToDisplay(cartContains);
        if (!cartContains.isDisplayed()) return 0;
        else return Integer.parseInt(cartContains.getText());
    }

}
