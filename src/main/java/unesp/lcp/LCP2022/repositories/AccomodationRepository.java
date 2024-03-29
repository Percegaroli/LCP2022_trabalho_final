/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unesp.lcp.LCP2022.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import unesp.lcp.LCP2022.models.Accomodation;

/**
 *
 * @author brunopercegaroli
 */
public interface AccomodationRepository extends JpaRepository<Accomodation, Long> {
    public List<Accomodation> findAllByCustomerCpfAndCheckoutDateIsNull(String cpf);

    public Optional<Accomodation> findByCustomerCpfAndReservationId(String cpf, long id);
}
