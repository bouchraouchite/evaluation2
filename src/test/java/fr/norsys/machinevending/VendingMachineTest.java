package fr.norsys.machinevending;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    @Test
    public void testSelectProduct() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(Product.WATER, 5);
        vendingMachine.addProduct(Product.COCA, 3);
        String result = vendingMachine.selectProduct(Product.COCA);
        assertEquals("Product not available or insufficient amount paid", result);
    }

    @Test
    public void testCancelRequest() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(Product.WATER, 5);
        vendingMachine.addProduct(Product.COCA, 3);
        vendingMachine.addCoins(Coin.ONE, 10);
        vendingMachine.addCoins(Coin.TWO, 5);
        vendingMachine.addCoins(Coin.FIVE, 3);
        vendingMachine.addCoins(Coin.TEN, 2);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.selectProduct(Product.COCA);
        String refund = vendingMachine.cancelRequest();
        assertEquals("Refund: 2", refund);
    }

    @Test
    public void testReset() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(Product.WATER, 5);
        vendingMachine.addProduct(Product.COCA, 3);
        vendingMachine.addCoins(Coin.ONE, 10);
        vendingMachine.addCoins(Coin.TWO, 5);
        vendingMachine.addCoins(Coin.FIVE, 3);
        vendingMachine.addCoins(Coin.TEN, 2);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.selectProduct(Product.COCA);
        vendingMachine.reset();

    }
}
