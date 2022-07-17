/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import unesp.lcp.LCP2022.DTOs.ReservationDTO;
import unesp.lcp.LCP2022.models.Customer;
import unesp.lcp.LCP2022.models.Reservation;

/**
 *
 * @author Bruno
 */
public interface ReservationService {
    public List<Reservation> getReservationByCustomerAndDate(Customer customer, Date date);
    
    public Reservation reservateRoom(ReservationDTO reservationDTO);
}
