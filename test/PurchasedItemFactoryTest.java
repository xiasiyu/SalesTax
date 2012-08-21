import PurchasedItem.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PurchasedItemFactoryTest {
    @Test
    public void should_parse_product_from_input() {
        String itemInfo = "1 imported bottle of perfume at 27.99";

        PurchasedItemFactory purchasedItemFactory = new PurchasedItemFactory();
        PurchasedItem purchasedItem = purchasedItemFactory.parseProduct(itemInfo);

        assertThat(purchasedItem.toPrintString(), is("1 imported bottle of perfume: 32.19"));

    }
}
