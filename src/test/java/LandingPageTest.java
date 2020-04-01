import pages.CategoryPage;
import pages.LandingPage;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SearchResultPage;

import static com.github.webdriverextensions.Bot.open;

@RunWith(WebDriverRunner.class)
@Chrome
public class LandingPageTest {

    LandingPage landingPage;
    CategoryPage categoryPage;
    SearchResultPage searchResultPage;

    String existingItem = "smart watch";
    String nonExistingItem = "YouWillFindNothing";
    String validCategory = "Fashion";

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
        landingPage.selectSubmenuCategory(validCategory);
        categoryPage.assertIsOpen(validCategory);
    }

    // TODO: implement TC
    @Test
    public void selectDailyDealAddToCartAndRemoveFromCart() {

    }

    // TODO: implement TC
    @Test
    public void selectShipToCountry() {

    }
}
