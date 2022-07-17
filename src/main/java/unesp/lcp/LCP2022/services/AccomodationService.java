/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unesp.lcp.LCP2022.services;

import java.util.List;
import java.util.Optional;
import unesp.lcp.LCP2022.models.Accomodation;

/**
 *
 * @author brunopercegaroli
 */
public interface AccomodationService {
     Optional<Accomodation> findAccomodationByCustomerCPF(String cpf);
     
     Optional<Accomodation> makeCheckout(String cpf, long reservationId);
     
     List<Integer> getDaysAccomodation(Accomodation  Acc, int daysReserved);
}
