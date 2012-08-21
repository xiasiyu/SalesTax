import PurchasedItem.PurchasedItem;

import java.io.IOException;
import java.util.List;

public class main {
    public static void main() throws IOException {
        InputParser inputParser = new InputParser();
        inputParser.setReader("src/InputFile/input3.txt");

        List<PurchasedItem> purchasedItems = inputParser.parseItemList();
        Receipt receipt = new Receipt(purchasedItems);
        receipt.toPrintReceipt();
    }
}
