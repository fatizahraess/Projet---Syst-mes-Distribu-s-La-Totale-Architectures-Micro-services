package net.essadiki.ebankservice.services;

import lombok.AllArgsConstructor;
import net.essadiki.ebankservice.entities.BankAccount;
import net.essadiki.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EbankService {
    private final BankAccountRepository accountRepository;

    public List<BankAccount> getAllBankAccounts() {
        return accountRepository.findAll();
    }

    public BankAccount getBankAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));

    }

    public BankAccount save(BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
           return accountRepository.save(bankAccount);

    }
}