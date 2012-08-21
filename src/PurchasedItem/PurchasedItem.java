package PurchasedItem;

import java.math.BigDecimal;

public class PurchasedItem {
    private static final BigDecimal ROUNDING_PRECISION = new BigDecimal("0.05");
    public static final String IMPORTED = "imported ";
    public static final String CONNECTOR = ": ";
    private Integer count;
    private String itemName;
    private double price;
    private float tax;

    public PurchasedItem(String itemName, double price, Integer count) {
        this.count = count;
        this.itemName = itemName;
        this.price = price;
        this.tax = this.calculateTaxForItem();
    }

    public String toPrintString() {
        return this.count + " " + itemName + CONNECTOR + updatePriceByTax();
    }

    public boolean isImportedGoods() {
        if (itemName.contains(IMPORTED)) {
            return true;
        }
        return false;
    }

    public BigDecimal updatePriceByTax() {
        BigDecimal tax = getTotalTax();
        BigDecimal totalPrice = tax.add(new BigDecimal(price));
        return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);

    }

    public BigDecimal getTotalTax() {
        BigDecimal bigDecimal = new BigDecimal(price * calculateTaxForItem());
        String value = String.valueOf(Math.ceil(bigDecimal.divide(ROUNDING_PRECISION).doubleValue()));
        return new BigDecimal(value).multiply(ROUNDING_PRECISION);
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public float calculateTaxForItem() {
        return 0;
    }

    public float getTax() {
        return tax;
    }

    public BigDecimal getPrice() {
        return updatePriceByTax();
    }
}
