package factory;

public class Latte extends Beverage{
    @Override
    public String getName() {
        return "Latte";
    }

    @Override
    public double getPrice() {
        return 3.80;
    }
}
