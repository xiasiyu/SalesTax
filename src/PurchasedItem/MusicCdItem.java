package PurchasedItem;

public class MusicCdItem extends PurchasedItem {
    public MusicCdItem(String itemName, double price, Integer count) {
        super(itemName, price, count);
    }

    @Override
    public float calculateTaxForItem() {
        if(isImportedGoods()) {
            return new Float(0.15);
        }
        return new Float(0.1);
    }
}
