package observer;

import model.Order;
import model.OrderStatus;

public class CustomerNotifier implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getStatus() == OrderStatus.READY) {
            System.out.println("[NOTIFICATION] - " + order.getStatus()
                    + "- The oder " + " #" + order.getId() + "  is ready!");
        } else if (order.getStatus() == OrderStatus.DELIVERED) {
            System.out.println("[NOTIFICATION] - " + order.getStatus()
                    + "- The order has been delivered to the customer");
        }
    }
}
