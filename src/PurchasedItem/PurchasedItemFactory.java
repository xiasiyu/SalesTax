package PurchasedItem;

public class PurchasedItemFactory {
    public PurchasedItem parseProduct(String line) {
        String[] split = line.split(" at ");

        String itemName = split[0].substring(2);
        Character co = split[0].charAt(0);
        String count = String.valueOf(co);
        Double price = Double.valueOf(split[1]);

        if (itemName.contains("book")) {
            return createBookItem(itemName, count, price);
        }
        if (itemName.contains("chocolate")) {
            return createFoodItem(itemName, count, price);
        }
        if (itemName.contains("pills")) {
            return createMedicineItem(itemName, count, price);
        }
        return createOtherItem(itemName, count, price);
    }

    private OtherItem createOtherItem(String itemName, String count, Double price) {
        return new OtherItem(Integer.parseInt(count), itemName, price);
    }

    private MedicineItem createMedicineItem(String itemName, String count, Double price) {
        return new MedicineItem(Integer.parseInt(count), itemName, price);
    }

    private FoodItem createFoodItem(String itemName, String count, Double price) {
        return new FoodItem(Integer.parseInt(count), itemName, price);
    }

    private BookItem createBookItem(String itemName, String count, Double price) {
        return new BookItem(Integer.parseInt(count), itemName, price);
    }
}
