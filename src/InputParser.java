import PurchasedItem.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private String filename;

    public InputParser() {
    }

    public void setReader(String filename) {
        this.filename = filename;
    }

    public List<PurchasedItem> parseItemList() throws IOException {
        List<PurchasedItem> shoppingItems = new ArrayList<PurchasedItem>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        String eachLine = null;
        while((eachLine = bufferedReader.readLine()) != null) {
            shoppingItems.add(new PurchasedItemFactory().parseProduct(eachLine));
        }

        bufferedReader.close();
        return shoppingItems;
    }
}
