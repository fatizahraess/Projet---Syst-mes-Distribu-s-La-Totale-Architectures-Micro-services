package net.essadiki.ebankservice.controllers;
import lombok.AllArgsConstructor;
import net.essadiki.ebankservice.entities.BankAccount;
import net.essadiki.ebankservice.services.EbankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EbankRestController {
    private final EbankService ebankService;

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {
        return ebankService.getAllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable  String id) {
        return ebankService.getBankAccountById(id);
    }

    @PostMapping("/accounts")
    public BankAccount save(@RequestBody  BankAccount bankAccount){
        return ebankService.save(bankAccount);
    }
}