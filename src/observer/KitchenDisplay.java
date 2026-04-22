package observer;

import model.Order;
import model.OrderStatus;

public class KitchenDisplay implements OrderObserver{

    @Override
    public void update(Order order) {
        if (order.getStatus() == OrderStatus.RECEIVED) {
            System.out.println("[KITCHEN] - " + order.getStatus() + "-  New order #"
                    + order.getId() + "  — items: " + order.getBeverages());
        } else if (order.getStatus() == OrderStatus.PREPARING) {
            System.out.println("[KITCHEN] - " + order.getStatus() + "-  Preparing order #" + order.getId() + "...");
        } else if (order.getStatus() == OrderStatus.READY) {
            System.out.println("[KITCHEN] - " + order.getStatus() + "-  Order #" + order.getId() + " is ready for pickup.");
        }
    }
}
