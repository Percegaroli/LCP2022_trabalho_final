/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unesp.lcp.LCP2022.models.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String> {
    
}