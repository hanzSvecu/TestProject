import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.junitrunner.annotations.Firefox;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.*;

import static com.github.webdriverextensions.Bot.open;

@RunWith(WebDriverRunner.class)
@Chrome
//@Firefox
//@Opera
//@Edge
public class ShoppingCartTest {

    private LandingPage landingPage;
    private SearchResultPage searchResultPage;
    private ItemDetailPage itemDetailPage;
    private GeneralHeader generalHeader;
    private ShoppingCart shoppingCart;

    // make preparation to enter shopping cart and then enter the page
    @Before
    public void openPage() {
        open(landingPage);
        generalHeader.validateCartIsEmpty();
        landingPage.searchForItem("coffee");
        searchResultPage.selectAnyItem();
        itemDetailPage.addToCart();
        generalHeader.validateCartContainsItems(1);
    }

    @Test
    public void addItemToCartAndRemoveItemFromCart() {
        shoppingCart.removeItem();
    }

    @Test
    public void addItemToCartAndGoToCheckout() {
        shoppingCart.checkout();
    }

}
