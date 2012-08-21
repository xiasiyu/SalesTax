package PurchasedItem;

public class BookItem extends PurchasedItem {
    public BookItem(Integer count, String itemName, double price) {
       super(itemName, price, count);
    }

    @Override
    public float calculateTaxForItem() {
        if(isImportedGoods()) {
            return new Float(0.05);
        }
        else
            return new Float(0);

    }
}
