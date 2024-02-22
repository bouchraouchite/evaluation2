package fr.norsys.machinevending;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    Map<Product, Integer> products = new HashMap<>();
    Map<Coin, Integer> coins = new HashMap<>();
    int currentAmount = 0;

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void addCoins(Coin coin, int quantity) {
        coins.put(coin, quantity);
    }

    public void insertCoin(Coin coin) {
        currentAmount += coin.getValue();
    }

    public String selectProduct(Product product) {
        if (products.containsKey(product) && products.get(product) > 0 && currentAmount >= product.getPrice()) {
            int change = currentAmount - product.getPrice();
            products.put(product, products.get(product) - 1);
            currentAmount = 0;
            return "Product: " + product.name() + ", Change: " + change;
        } else {
            return "Product not available or insufficient amount paid";
        }
    }

    public String cancelRequest() {
        int refund = currentAmount;
        currentAmount = 0;
        return "Refund: " + refund;
    }

    public void reset() {
        products.clear();
        coins.clear();
        currentAmount = 0;
    }

    public Object getProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProducts'");
    }
}