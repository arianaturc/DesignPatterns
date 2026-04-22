package factory;

public abstract class Beverage {
    public abstract String getName();
    public abstract double getPrice();

    @Override
    public String toString() {
        return getName();
    }
}
