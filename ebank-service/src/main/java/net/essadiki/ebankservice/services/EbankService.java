package net.essadiki.ebankservice.services;

import lombok.AllArgsConstructor;
import net.essadiki.ebankservice.entities.BankAccount;
import net.essadiki.ebankservice.feign.CustomerRestClient;
import net.essadiki.ebankservice.model.Customer;
import net.essadiki.ebankservice.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class EbankService {
    private final   BankAccountRepository accountRepository;
    private final   CustomerRestClient customerRestClient;


    @McpTool(description = "Get all Bank accounts")
    public List<BankAccount> getAllBankAccounts() {
        return accountRepository.findAll();
    }

    @McpTool(description = "Get a bank account by id")
    public BankAccount getBankAccountById(@McpToolParam(description = "The bank account id") String id) {
        BankAccount bankAccount= accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
        bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;

    }

    @McpTool(description = "Save a new bank account")
    public BankAccount save(@McpToolParam(description = "The bank account to save (balance,type,customerId) ") BankAccount bankAccount){
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return accountRepository.save(bankAccount);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}