package app;

import factory.Beverage;
import factory.BeverageFactory;
import factory.BeverageType;
import model.Order;
import model.OrderStatus;
import observer.CustomerNotifier;
import observer.KitchenDisplay;
import observer.ReceiptPrinter;

public class CoffeeShopApp {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("===     Coffee Shop     ===\n");

        Order order = new Order();

        order.attach(new KitchenDisplay());
        order.attach(new CustomerNotifier());
        order.attach(new ReceiptPrinter());

        Beverage latte = BeverageFactory.createBeverage(BeverageType.LATTE);
        Beverage espresso = BeverageFactory.createBeverage(BeverageType.ESPRESSO);
        Beverage cappuccino = BeverageFactory.createBeverage(BeverageType.CAPPUCCINO);

        order.addBeverage(latte);
        order.addBeverage(espresso);
        order.addBeverage(cappuccino);

        order.setStatus(OrderStatus.RECEIVED);
        Thread.sleep(500);

        order.setStatus(OrderStatus.PREPARING);
        Thread.sleep(1000);

        order.setStatus(OrderStatus.READY);
        Thread.sleep(500);

        order.setStatus(OrderStatus.DELIVERED);

        System.out.println("\n=== Have a great day! ===");
    }

}
