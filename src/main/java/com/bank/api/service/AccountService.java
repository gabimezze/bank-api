package com.bank.api.service;

import com.bank.api.model.Account;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    private final Map<Long, Account> accounts = new HashMap<>();
    private long nextId = 1;

    public Account createAccount(Account account) {
        account.setId(nextId++);
        account.setAtiva(true);
        accounts.put(account.getId(), account);
        return account;
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    public Account getAccountById(Long id) {
        return accounts.get(id);
    }

    public Account getAccountByCpf(String cpf) {
        return accounts.values().stream()
                .filter(account -> account.getCpfTitular().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Account closeAccount(Long id) {
        Account account = accounts.get(id);
        if (account != null) {
            account.setAtiva(false);
        }
        return account;
    }

    public Account deposit(Long id, double valor) {
        Account account = accounts.get(id);
        if (account != null && valor > 0) {
            account.setSaldo(account.getSaldo() + valor);
        }
        return account;
    }

    public Account withdraw(Long id, double valor) {
        Account account = accounts.get(id);
        if (account != null && valor > 0 && account.getSaldo() >= valor) {
            account.setSaldo(account.getSaldo() - valor);
        }
        return account;
    }

    public Account transfer(Long origem, Long destino, double valor) {
        Account accountOrigem = accounts.get(origem);
        Account accountDestino = accounts.get(destino);

        if (accountOrigem != null && accountDestino != null && valor > 0 && accountOrigem.getSaldo() >= valor) {
            accountOrigem.setSaldo(accountOrigem.getSaldo() - valor);
            accountDestino.setSaldo(accountDestino.getSaldo() + valor);
        }
        return accountOrigem;
    }

}
