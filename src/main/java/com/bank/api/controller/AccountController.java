package com.bank.api.controller;

import com.bank.api.model.Account;
import com.bank.api.service.AccountService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class AccountController {
    @GetMapping("/")
    public String getProjectInfo() {
        String projectName = "Projeto Bank API"; 
        String teamMembers = "Gabriela Gomes Cezar"; 

        return "Projeto: " + projectName + "\nIntegrantes da equipe: " + teamMembers;
    }

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public Account getAccountByCpf(@PathVariable String cpf) {
        return accountService.getAccountByCpf(cpf);
    }

    @PutMapping("/encerrar/{id}")
    public Account closeAccount(@PathVariable Long id) {
        return accountService.closeAccount(id);
    }

    @PostMapping("/deposito")
    public Account deposit(@RequestParam Long id, @RequestParam double valor) {
        return accountService.deposit(id, valor);
    }

    @PostMapping("/saque")
    public Account withdraw(@RequestParam Long id, @RequestParam double valor) {
        return accountService.withdraw(id, valor);
    }

    @PostMapping("/pix")
    public Account transfer(@RequestParam Long origem, @RequestParam Long destino, @RequestParam double valor) {
        return accountService.transfer(origem, destino, valor);
    }

}
