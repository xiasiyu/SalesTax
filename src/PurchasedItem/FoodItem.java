package PurchasedItem;

public class FoodItem extends PurchasedItem {
    public FoodItem(Integer count, String itemName, double price) {
        super(itemName, price, count);
    }

    @Override
    public float calculateTaxForItem() {
        if(isImportedGoods()) {
            return new Float(0.05);
        }
        return 0;
    }
}
