package PurchasedItem;

public class OtherItem extends PurchasedItem {
    public OtherItem(Integer count, String itemName, double price) {
        super(itemName, price, count);

    }

    @Override
    public float calculateTaxForItem() {
        if (isImportedGoods()) {
            return new Float(0.15);
        }
        return new Float(0.1);
    }
}
