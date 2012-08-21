import PurchasedItem.BookItem;
import PurchasedItem.MusicCdItem;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PurchasedItemTest {
    @Test
    public void should_print_receipt_for_one_item_without_sale_tax() {
        BookItem item = new BookItem(1, "book", 12.49);

        item.updatePriceByTax();

        assertThat(item.toPrintString(), is("1 book: 12.49"));
    }

    @Test
    public void should_print_receipt_for_one_item_with_normal_sale_tax() {
        MusicCdItem item = new MusicCdItem("music CD", 14.99, 1);

        item.updatePriceByTax();

        assertThat(item.toPrintString(), is("1 music CD: 16.49"));
    }

    @Test
    public void is_product_imported_or_not() {
        BookItem purchasedItem = new BookItem(1, "imported box of chocolates", 10.00);

        assertThat(purchasedItem.isImportedGoods(), is(true));

    }

    @Test
    public void should_print_receipt_for_imported_item_with_sale_tax_for_imported_goods() {
        BookItem item = new BookItem(1, "imported box of chocolates", 10.00);

        item.updatePriceByTax();

        assertThat(item.toPrintString(), is("1 imported box of chocolates: 10.55"));
    }

    @Test
    public void should_print_receipt_for_item_name_contains_imported__with_sale_tax_for_imported_goods() {
        BookItem item = new BookItem(1, "box of imported chocolates", 11.25);

        item.updatePriceByTax();

        assertThat(item.toPrintString(), is("1 box of imported chocolates: 11.85"));
    }
}
