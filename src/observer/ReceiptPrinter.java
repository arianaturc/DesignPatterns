package observer;

import factory.Beverage;
import model.Order;
import model.OrderStatus;

public class ReceiptPrinter implements OrderObserver{
    @Override
    public void update(Order order) {
        if (order.getStatus() == OrderStatus.DELIVERED) {
            System.out.println("[RECEIPT]  ---------- Receipt ----------");
            System.out.println("[RECEIPT]  Order #" + order.getId());

            for (Beverage b : order.getBeverages()) {
                System.out.printf("[RECEIPT]    - %-12s $%.2f%n", b.getName(), b.getPrice());
            }

            System.out.printf("[RECEIPT]  Total: $%.2f%n", order.getTotal());
            System.out.println("[RECEIPT]  -----------------------------");
        }
    }
}
