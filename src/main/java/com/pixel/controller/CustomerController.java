package com.pixel.controller;

import com.pixel.model.Customer;
import com.pixel.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping("/customers")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @PutMapping("/customer/{id}")
    public Customer updateACustomer(@RequestBody Customer customer,@PathVariable int id) {
        return customerRepository.findById(id)
                .map(c-> {
                    c.setName(customer.getName());
                    c.setUsername(customer.getUsername());
                    c.setEmail(customer.getEmail());
                    return customerRepository.save(customer);
                }).orElseGet(() -> {
                    customer.setId(id);
                    return customerRepository.save(customer);
                });
    }
    @DeleteMapping("/cust/{id}")
    public String deleteCustomer(@PathVariable int id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException();
        }
        customerRepository.deleteById(id);
        return "Customer with id; " + id + "Deleted ";
    }
}
