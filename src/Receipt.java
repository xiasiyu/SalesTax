import PurchasedItem.PurchasedItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<PurchasedItem> purchasedItems;

    public Receipt(List<PurchasedItem> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    public void toPrintReceipt() {
        List<String> itemNameList = new ArrayList<String>();
        for (PurchasedItem purchasedItem : purchasedItems) {
            if(itemNameList.contains(purchasedItem.getItemName())) {
                  purchasedItem.setCount(purchasedItem.getCount() + 1);
            }
            itemNameList.add(purchasedItem.getItemName());
        }

        for (PurchasedItem purchasedItem : purchasedItems) {
            System.out.println(purchasedItem.toPrintString());
        }

        System.out.println("total tax: " + getTotalTax().toString());
        System.out.println("total price: " + getTotalPrice());
    }

    public BigDecimal getTotalTax() {
        BigDecimal tax = new BigDecimal(0.0);
        for (PurchasedItem purchasedItem : purchasedItems) {
            if(purchasedItem != null){
                tax = tax.add(purchasedItem.getTotalTax());
            }
        }
        return tax.setScale(2);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (PurchasedItem purchasedItem : purchasedItems) {
            totalPrice = totalPrice.add(purchasedItem.getPrice());
        }
        return totalPrice.setScale(2);
    }
}
