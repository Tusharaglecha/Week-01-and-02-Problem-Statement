import java.util.*;

public class InventoryManager {
    private Map<String, Integer> stock = new HashMap<>();
    private Map<String, Integer> waitingList = new LinkedHashMap<>();
    private int waitCount = 0;

    public synchronized String purchaseItem(String productId, int userId) {
        int currentStock = stock.getOrDefault(productId, 0);
        if (currentStock > 0) {
            stock.put(productId, currentStock - 1);
            return "Success, " + (currentStock - 1) + " units remaining";
        } else {
            waitingList.put(String.valueOf(userId), ++waitCount);
            return "Added to waiting list, position #" + waitCount;
        }
    }
}
