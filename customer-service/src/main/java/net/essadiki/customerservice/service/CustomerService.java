package net.essadiki.customerservice.service;


import lombok.AllArgsConstructor;
import net.essadiki.customerservice.entities.Customer;
import net.essadiki.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Customer Not found"));
    }

    public Customer saveCustomer( Customer customer){
        return customerRepository.save(customer);
    }
}