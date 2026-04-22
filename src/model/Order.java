package model;

import factory.Beverage;
import observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int idCounter = 1;

    private final int id;
    private final List<Beverage> beverages;
    private final List<OrderObserver> observers;
    private OrderStatus status;

    public Order() {
        this.id = idCounter++;
        this.beverages = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.status = OrderStatus.RECEIVED;
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
    }
    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setStatus(OrderStatus newStatus) {
        this.status = newStatus;
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotal() {
        return beverages.stream().mapToDouble(Beverage::getPrice).sum();
    }
}
