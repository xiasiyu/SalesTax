import java.math.BigDecimal;

public class PurchasedItem {
    public static final String CONNECTOR = ": ";
    private String itemName;
    private double price;
    private double tax;
    private double priceWithTax;

    public PurchasedItem(String itemName, double price, double tax) {
        this.itemName = itemName;
        this.price = price;
        this.tax = tax;
    }

    public PurchasedItem() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void updatePriceByTax() {
        BigDecimal bigDecimal = new BigDecimal(price * (1 + tax));
        priceWithTax = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public String toPrintString() {
        String replace = itemName.replace("imported ", "");
        if(this.isImportedGoods()) {
            return "imported " + replace + CONNECTOR + priceWithTax;
        }
        return itemName + CONNECTOR +priceWithTax;
    }

    public boolean isImportedGoods() {
        if(itemName.contains("imported")) {
            return true;
        }
        return false;
    }
}
