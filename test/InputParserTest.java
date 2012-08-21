import PurchasedItem.PurchasedItem;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputParserTest {
    @Test
    public void should_get_item_info_by_reading_file() throws IOException {
        InputParser inputParser = new InputParser();
        inputParser.setReader("src/InputFile/input3.txt");

        List<PurchasedItem> items = inputParser.parseItemList();
        Receipt receipt = new Receipt(items);
        receipt.toPrintReceipt();

        assertThat(items.get(0).toPrintString(), is("1 imported bottle of perfume: 32.19"));
    }
}
