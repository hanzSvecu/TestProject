package pages;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.github.webdriverextensions.Bot.*;

public class LandingPage extends WebPage {

    private WebDriver driver = WebDriverExtensionsContext.getDriver();

    @FindBy(id = "gh-logo")
    private WebElement companyLogo;

    @FindBy(id = "gh-ac")
    private WebElement itemSearchField;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/ul")
    private WebElement staticCategorySubmenu;

    // TODO: remove
    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/ul/li[4]/a")
    private WebElement fashionCategory;


    @Override
    public void open(Object... arguments) {
        open("https://www.ebay.com");
        assertIsOpen();
    }
    @Override
    public void assertIsOpen(Object... arguments) {
        assertAttributeEquals("alt", "eBay Logo", companyLogo);
    }

    public void searchForItem(String item) {
        type(item, itemSearchField);
        click(searchButton);
    }

    public void selectFashionSubmenuCategory() {
        fashionCategory.click();
    }
}
