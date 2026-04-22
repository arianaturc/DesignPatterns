package factory;

public class BeverageFactory{
    public static Beverage createBeverage(BeverageType type) {
        if (type == null) {
            throw new IllegalArgumentException("Beverage type cannot be null");
        }

        return switch (type) {
            case ESPRESSO -> new Espresso();
            case LATTE -> new Latte();
            case CAPPUCCINO -> new Cappuccino();
        };
    }
}
