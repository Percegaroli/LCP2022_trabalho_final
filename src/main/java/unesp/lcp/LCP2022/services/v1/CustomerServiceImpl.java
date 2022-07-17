/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services.v1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.lcp.LCP2022.models.Customer;
import unesp.lcp.LCP2022.repositories.CustomerRepository;
import unesp.lcp.LCP2022.services.CustomerService;

/**
 *
 * @author brunopercegaroli
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getCustomerByCPF(String cpf) {
        return customerRepository.findByCpf(cpf);
    }
    
    @Override
    public Optional<Customer> getCustomerByName(String name){
        return customerRepository.findByName(name);
    }
    
    @Override
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
