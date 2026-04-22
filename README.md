# Coffee Shop  — Design Patterns Demo 

A small Java project that demonstrates **two design patterns** working together in a single scenario: a coffee shop taking an order, preparing it, and moving it through its lifecycle while several subsystems react to each status change.

A coffee shop needs to:
1. Create different types of beverages (Espresso, Latte, Cappuccino).
2. React to each order status change from several independent subsystems (the kitchen display, a customer notifier, a receipt printer).

## Design Patterns Used
The Factory pattern centralizes object creation so client code doesn't depend on concrete classes. Here, `BeverageFactory.createBeverage(type)` returns the right `Beverage` subclass based on a `BeverageType` enum, so `CoffeeShopApp` never calls `new Latte()` directly. Adding a new drink only requires a new subclass and one line in the factory — the rest of the app is unchanged.

### Observer — `model.Order` (Subject) and `observer.*` (Observers)
The Observer pattern lets one object make changes to many observers. `Order` keeps a list of `OrderObserver` instances and notifies all of them whenever its status changes; each observer (`KitchenDisplay`, `CustomerNotifier`, `ReceiptPrinter`) independently decides which statuses it cares about. New reactions can be added without changing the `Order` class or the existing observers.

The `BeverageFactory` **creates** the beverages that go into an `Order`. The `Order` is then the **Subject** in the Observer pattern, notifying all attached observers as it moves through `RECEIVED → PREPARING → READY → DELIVERED`.
