package factory;

public class Cappuccino extends Beverage{
    @Override
    public String getName() {
        return "Cappuccino";
    }

    @Override
    public double getPrice() {
        return 5.00;
    }
}
