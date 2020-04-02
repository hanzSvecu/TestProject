import pages.*;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.github.webdriverextensions.Bot.open;

@RunWith(WebDriverRunner.class)
@Chrome
public class LandingPageTest {

    private LandingPage landingPage;
    private CategoryPage categoryPage;
    private SearchResultPage searchResultPage;
    private ItemDetailPage itemDetailPage;
    private GeneralHeader generalHeader;
    private  ShoppingCart shoppingCart;

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
        landingPage.selectSubmenuCategory(validCategory);
        categoryPage.assertIsOpen(validCategory);
    }

    // check that there is no number on cart
    // LANDING PAGE
    // => Hoover over cart - popup + text shown
    // find any item - i.e. search for "coffee"
    // => insert text "coffee" into Search field
    // => click on search
    // SEARCH PAGE
    // select any item
    // => click on item
    // ITEM DETAIL PAGE
    // add it to cart
    // => click on button Add to cart
    // SHOPPING CART PAGE
    // Verify text on screen
    // => text Shopping cart (1 item)
    // check change of the icon of the cart
    // => via text of the icon
    // add additional items
    // check change of the icon of the cart
    // => via text of the icon

    // click on Remove
    // Verify text on screen
    // => text Shopping cart
    // => text "was removed from your cart"
    // => click on the link of the removed item again

    // TODO: implement TC
    @Test
    public void addItemToCartAndRemoveItemFromCart() {
        generalHeader.validateCartIsEmpty();
        landingPage.searchForItem("coffee");
        searchResultPage.selectAnyItem();
        itemDetailPage.addToCart();
        generalHeader.validateCartContainsItems(1);
        shoppingCart.changeQuantity(5);

    }


    // LANDING PAGE
    // => insert text "coffee" into Search field
    // => click on search
    // SEARCH PAGE
    // select the item
    // => click on item
    // ITEM DETAIL PAGE
    // add it to cart
    // => click on button Add to cart
    // SHOPPING CART PAGE
    // Verify text on screen
    // => text Shopping cart (1 item)
    // Go to Checkout
    // => click on button Go to Checkout
    // Continue as guest
    // => on a shown popup, click on Continue as guest
    // CHECKOUT PAGE
    // => identify the page by Checkout text
    // => check that Confirm and pay is DISABLED
    // TODO: implement TC
    @Test
    public void addItemToCartAndGoToCheckout() {

    }
}
