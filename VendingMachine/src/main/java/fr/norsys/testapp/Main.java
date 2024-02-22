package fr.norsys.testapp;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();


        vendingMachine.addProduct(Product.WATER, 5);
        vendingMachine.addProduct(Product.COCA, 3);
        vendingMachine.addCoins(Coin.ONE, 10);
        vendingMachine.addCoins(Coin.TWO, 5);
        vendingMachine.addCoins(Coin.FIVE, 3);
        vendingMachine.addCoins(Coin.TEN, 2);

        vendingMachine.insertCoin(Coin.TWO);
        String result = vendingMachine.selectProduct(Product.COCA);
        System.out.println(result);

        String refund = vendingMachine.cancelRequest();
        System.out.println(refund);

        vendingMachine.reset();
    }
}
