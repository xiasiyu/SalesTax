import PurchasedItem.BookItem;
import PurchasedItem.PurchasedItem;
import org.junit.Test;

import java.util.ArrayList;

public class ReceiptTest {
    @Test
    public void should_print_item_list() {
        ArrayList<PurchasedItem> purchasedItems = new ArrayList<PurchasedItem>();
        BookItem book = new BookItem(1, "book", 10.00);
        purchasedItems.add(book);
        purchasedItems.add(book);
        Receipt receipt = new Receipt(purchasedItems);

        receipt.toPrintReceipt();
    }
}
