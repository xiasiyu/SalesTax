package PurchasedItem;

public class MedicineItem extends PurchasedItem {
    public MedicineItem(Integer count, String itemName, double price) {
        super(itemName, price, count);
    }

    @Override
    public float calculateTaxForItem() {
        if (isImportedGoods()) {
            return new Float(0.05);
        } else
            return new Float(0);

    }
}
