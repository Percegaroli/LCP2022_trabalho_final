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
import unesp.lcp.LCP2022.models.Room;

/**
 *
 * @author Bruno
 */
public interface ReservationService {
    public Reservation reservateRoom(int roomID, String customerCPF, Date startDate, int accomodationDays);
    
    public List<Reservation> getReservationByRoom(Optional<Room> room);
   
    public Boolean getRoomAvailability(List<Reservation> reservas, int diaReserva);
    
    public List<Reservation> getReservationByCustomer(Customer customer); 
   
    public List<Reservation> getReservationByCustomerAndDate(Customer customer, Date date);
}
