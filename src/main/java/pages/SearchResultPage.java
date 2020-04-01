package pages;

import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchResultPage extends WebPage {

    @FindBy(className = "srp-controls__count-heading")
    public WebElement searchedItemResult;

    @Override
    public void open(Object... arguments) {
        assertIsOpen();
    }
    // validates that the name of the searched items is present in number of items found
    @Override
    public void assertIsOpen(Object... arguments) {
        List<WebElement> pageIds = searchedItemResult.findElements(By.tagName("span"));
        assertEquals(arguments[0], pageIds.get(1).getText());
    }

    public void itemFound(){
        assertTrue(getNumberOfFoundItems() > 0);
    }

    public void itemNotFound(){
        assertTrue(getNumberOfFoundItems() == 0);
    }

    // utility methods
    private int getNumberOfFoundItems() {
        List<WebElement> pageIds = searchedItemResult.findElements(By.tagName("span"));
        int countOfFoundItems = Integer.parseInt(pageIds.get(0).getText().replace(",",""));
        return countOfFoundItems;
    }
}
