/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import unesp.lcp.LCP2022.models.Customer;
import unesp.lcp.LCP2022.models.Reservation;
import unesp.lcp.LCP2022.models.Room;

/**
 *
 * @author Bruno
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public List<Reservation> findAllByRoom(Optional<Room> room);
    public List<Reservation> findAllByCustomer(Customer customer);
    public List<Reservation> findByCustomerAndCheckinDate(Customer customer, Date checkinDate);
}
