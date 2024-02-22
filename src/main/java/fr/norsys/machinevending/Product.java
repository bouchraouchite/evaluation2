package fr.norsys.machinevending;

public enum Product {

    WATER(5), COCA(7), TWIX(10), BUENO(12);

    private int price;

    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}