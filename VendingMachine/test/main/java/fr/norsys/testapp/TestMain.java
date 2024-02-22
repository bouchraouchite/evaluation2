package fr.norsys.testapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testVendingMachineInteraction() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(Product.WATER, 5);
        vendingMachine.addProduct(Product.COCA, 3);
        vendingMachine.addCoins(Coin.ONE, 10);
        vendingMachine.addCoins(Coin.TWO, 5);
        vendingMachine.addCoins(Coin.FIVE, 3);
        vendingMachine.addCoins(Coin.TEN, 2);

        vendingMachine.insertCoin(Coin.TWO);
        String result = vendingMachine.selectProduct(Product.COCA);
        assertEquals("Product: COCA, Change: 0", result);

        String refund = vendingMachine.cancelRequest();
        assertEquals("Refund: 2", refund);

        vendingMachine.reset();
        assertTrue(vendingMachine.products.isEmpty());
        assertTrue(vendingMachine.coins.isEmpty());
        assertEquals(0, vendingMachine.currentAmount);
    }
}
