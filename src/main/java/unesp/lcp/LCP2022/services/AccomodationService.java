/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unesp.lcp.LCP2022.services;

import java.util.Optional;
import unesp.lcp.LCP2022.models.Accomodation;

/**
 *
 * @author brunopercegaroli
 */
public interface AccomodationService {
     Optional<Accomodation> findAccomodationByCustomerCPF(String cpf);
}
