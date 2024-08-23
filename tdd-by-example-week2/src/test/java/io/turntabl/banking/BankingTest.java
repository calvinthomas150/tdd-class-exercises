package io.turntabl.banking;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankingTest {

    BankAccount bankAccount;

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount();
    }

    @Test
    @DisplayName("When a new bank account is create the balance of the account should be zero.")
    void testBankAccountCreation() {
        assertEquals(BigDecimal.ZERO, bankAccount.getBalance());
    }

    @Test
    @DisplayName("When someone deposits money in to the account the balance should increase by that amount")
    void testAddingSingleAmount() {
        bankAccount.deposit(10);
        assertEquals(BigDecimal.valueOf(10), bankAccount.getBalance());
    }

    @Test
    @DisplayName("When I deposit an amount and then I deposit another amount the balance should increase be amount + another amount")
    void testAddingMultipleAmounts() {
        bankAccount.deposit(10);
        bankAccount.deposit(20);
        assertEquals(BigDecimal.valueOf(30), bankAccount.getBalance());
    }

    @Test
    @DisplayName("When I deposit an amount and then I deposit another amount the balance should increase be amount + another amount where floating point can go wrong")
    void testAddingMultipleAmountsFloatingPointArithmetic() {
        bankAccount.deposit(0.1);
        bankAccount.deposit(0.2);
        assertEquals(BigDecimal.valueOf(0.3), bankAccount.getBalance());
    }

    @Test
    @DisplayName("When I deposit an amount greater than zero but less than one then the balance should be increased by that amount")
    void testAddingPenniesAmounts() {
        bankAccount.deposit(0.05);
        assertEquals(BigDecimal.valueOf(0.05), bankAccount.getBalance());
    }

    @Test
    @DisplayName("When I deposit an amount less than 1p then an exception should be thrown")
    void testAddingLessThanOnePennyAmount() {
        assertThrows(InvalidAmountException.class, () -> bankAccount.deposit(0.005));
    }

    @Test
    @DisplayName("When I deposit an amount that has more than 2dp then an exception should be thrown")
    void testAddingTooManyDPAmount() {
        assertThrows(InvalidAmountException.class, () -> bankAccount.deposit(0.111));
    }

    @Test
    @DisplayName("When someone tries to deposit a negative amount the system should throw an Exception")
    void testDepositNegativeAmount() {
        assertThrows(InvalidAmountException.class, () -> bankAccount.deposit(-10));
    }

    @Test
    @DisplayName("When someone tries to deposit zero the system should throw an Exception")
    void testDepositZeroAmount() {
        assertThrows(InvalidAmountException.class, () -> bankAccount.deposit(0));
    }

    @Test
    @DisplayName("I can deposit amounts that include pennies, e.g. £1.50")
    void testDepositAmountWithPennies() {
        bankAccount.deposit(1.50);
        assertEquals(BigDecimal.valueOf(1.50), bankAccount.getBalance());
    }
}