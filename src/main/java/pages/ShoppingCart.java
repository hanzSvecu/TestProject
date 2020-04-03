package pages;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.waitForElementToDisplay;
import static org.junit.Assert.assertTrue;

public class ShoppingCart extends WebPage {

    private WebDriver driver = WebDriverExtensionsContext.getDriver();

    private GeneralHeader generalHeader;
    private CheckoutPage checkoutPage;

    @FindBy(xpath = "//*[@id=\"mainContent\"]/div/div[1]/h1")
    private WebElement title;

    @FindBy(id = "s1-11-sunnyup01-133135371-254121557014-qty[]-1-dropdown")
    private WebElement quantityDropdown;

    @FindBy(xpath = "//*[@id=\"mainContent\"]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/span[2]/button")
    private WebElement removeItemButton;

    @FindBy(xpath = "//*[@id=\"mainContent\"]/div/div[4]/div/div[1]/button")
    private WebElement checkoutButton;

    @FindBy(id = "gxo-btn")
    private WebElement checkoutContinueAsGuestButton;

    @Override
    public void open(Object... arguments) {
        assertIsOpen();
    }
    // validates that the name of the searched items is present in number of items found
    @Override
    public void assertIsOpen(Object... arguments) {
        assertTrue(title.getText().contains("Shopping cart"));
    }

    // quantity can be in interval 1 - 9 and 10+ (then adding functionality changes)
    public void changeQuantity(int quantity){
        int currentQuantity = generalHeader.getNumberOfItemsInCart();
        waitForElementToDisplay(quantityDropdown);
        quantityDropdown.click();
        waitForElementToDisplay(quantityDropdown);
        quantityDropdown.findElement(By.xpath("./option["+quantity+"]")).click();
        currentQuantity += quantity - 1;
        generalHeader.validateCartContainsItems(currentQuantity);
        driver.navigate().refresh();
        waitForElementToDisplay(title);
        assertTrue(title.getText().contains(currentQuantity+" item"));
    }

    public void removeItem(){
        waitForElementToDisplay(removeItemButton);
        removeItemButton.click();
        generalHeader.validateCartIsEmpty();
//        generalHeader.validateCartContainsItems(0);
    }

    public void checkout() {
        waitForElementToDisplay(checkoutButton);
        checkoutButton.click();
        waitForElementToDisplay(checkoutContinueAsGuestButton);
        checkoutContinueAsGuestButton.click();
        checkoutPage.assertIsOpen();
    }

}
