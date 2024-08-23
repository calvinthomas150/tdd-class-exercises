package io.turntabl.banking;

import java.math.BigDecimal;

public class BankAccount {

    private BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        deposit(BigDecimal.valueOf(amount));
    }

    public void deposit(double amount) {
        deposit(BigDecimal.valueOf(amount));
    }

    public void deposit(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.valueOf(0.01)) < 0 || amount.scale() > 2) throw new InvalidAmountException();
        balance = balance.add(amount);
    }
}
