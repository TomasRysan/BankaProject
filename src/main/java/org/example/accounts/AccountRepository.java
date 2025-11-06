package org.example.accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private final List<BaseBankAccount> accounts;

    public AccountRepository() {
        this.accounts = new ArrayList<>();
    }

    public void AddAccount(BaseBankAccount account) {
        this.accounts.add(account);
    }

    public List<BaseBankAccount> getAccounts() {
        return this.accounts;
    }
}
