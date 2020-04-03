import com.github.webdriverextensions.junitrunner.annotations.Edge;
import com.github.webdriverextensions.junitrunner.annotations.Firefox;
import com.github.webdriverextensions.junitrunner.annotations.Opera;
import pages.*;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.github.webdriverextensions.Bot.open;

@RunWith(WebDriverRunner.class)
@Chrome
@Firefox
//@Opera
//@Edge
public class SmokeTest {

    private LandingPage landingPage;
    private CategoryPage categoryPage;
    private SearchResultPage searchResultPage;

    private String existingItem = "smart watch";
    private String nonExistingItem = "YouWillFindNothing";
    private String validCategory = "Fashion";

    @Before
    public void openPage() {
        open(landingPage);
    }

    @Test
    public void searchForExistingItem() {
        landingPage.searchForItem(existingItem);
        searchResultPage.assertIsOpen(existingItem);
        searchResultPage.itemFound();
    }

    @Test
    public void searchForNonExistingItem() {
        landingPage.searchForItem(nonExistingItem);
        searchResultPage.assertIsOpen(nonExistingItem);
        searchResultPage.itemNotFound();
    }

    @Test
    public void selectCategoryTest() {
        landingPage.selectFashionSubmenuCategory();
        categoryPage.assertIsOpen(validCategory);
    }

}
