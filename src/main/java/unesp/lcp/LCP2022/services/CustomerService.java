/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unesp.lcp.LCP2022.services;

import java.util.List;
import java.util.Optional;
import unesp.lcp.LCP2022.models.Customer;

/**
 *
 * @author brunopercegaroli
 */
public interface CustomerService {
    public Optional<Customer> getCustomerByCPF(String cpf);
    public List<Customer> getAll();
    public Optional<Customer> getCustomerByName(String name);
}
