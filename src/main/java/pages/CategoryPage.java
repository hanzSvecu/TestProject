package pages;

import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CategoryPage extends WebPage {

    // TODO: future - if possible, use this to not use the full xpath in direct identifiers
    @FindBy(className ="b-breadcrumb__text b-link--tertiary truncate")
    public List<WebElement> pageIdentifiers;

    @FindBy(xpath = "/html/body/div[3]/div[2]/nav/ol/li[1]/a")
    public  WebElement pageIdentifier_1;

    @FindBy(xpath = "/html/body/div[3]/div[2]/nav/ol/li[2]/span")
    public  WebElement pageIdentifier_2;
    

    @Override
    public void open(Object... objects) {
        assertIsOpen();
    }

    // validation done via category tree;
    // example: ebay > Fashion
    // cannot be generalized to depth > 1
    @Override
    public void assertIsOpen(Object... objects) throws AssertionError {
        assertEquals("eBay", pageIdentifier_1.getText());
        assertEquals(objects[0], pageIdentifier_2.getText());
    }
}
