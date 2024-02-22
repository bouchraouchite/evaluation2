package fr.norsys.testapp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    @Test
    public void testSelectProduct() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(Product.WATER, 2);
        vendingMachine.addCoins(Coin.TWO, 5);
        vendingMachine.insertCoin(Coin.TWO);
        String result = vendingMachine.selectProduct(Product.WATER);
        assertEquals("Product: WATER, Change: 0", result);
    }

    @Test
    public void testCancelRequest() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addCoins(Coin.ONE, 10);
        vendingMachine.insertCoin(Coin.ONE);
        String result = vendingMachine.cancelRequest();
        assertEquals("Refund: 1", result);
    }

    @Test
    public void testReset() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(Product.COCA, 3);
        vendingMachine.addCoins(Coin.FIVE, 5);
        vendingMachine.reset();
        assertTrue(vendingMachine.products.isEmpty());
        assertTrue(vendingMachine.coins.isEmpty());
        assertEquals(0, vendingMachine.currentAmount);
    }
}
