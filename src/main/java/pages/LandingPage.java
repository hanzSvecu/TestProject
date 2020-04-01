package pages;

import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.github.webdriverextensions.Bot.*;

public class LandingPage extends WebPage {

    @FindBy(id = "gh-logo")
    public WebElement companyLogo;

    @FindBy(id = "gh-ac")
    public WebElement itemSearchField;

    @FindBy(id = "gh-btn")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/ul")
    public WebElement staticCategorySubmenu;

    // TODO: remove
    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/ul/li[4]/a")
    public WebElement fashionCategory;

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

    // TODO: method needs to be generalized - to use exact category and not the only one available
    public void selectSubmenuCategory(String category) {
        List<WebElement> staticCategories = staticCategorySubmenu.findElements(By.tagName("li"));
//        driver.FindElement(By.linkText(category));
//        for (WebElement li : staticCategories) {
////            WebElement a = li.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[4]/a"));
//                WebElement a = li.findElement(By.xpath("//a"));
//            System.out.println(a.getText());
//            if (a.getText().equals(category)) {
//                li.click();
//            }
//        }
        fashionCategory.click();
    }
}
