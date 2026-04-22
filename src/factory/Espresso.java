package factory;

public class Espresso extends Beverage{
    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public double getPrice() {
        return 2.50;
    }
}
