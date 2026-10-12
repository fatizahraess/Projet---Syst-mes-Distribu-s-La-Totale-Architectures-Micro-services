package net.essadiki.customerservice.repository;


import net.essadiki.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}