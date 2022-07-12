/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services.v1;

import org.springframework.beans.factory.annotation.Autowired;
import unesp.lcp.LCP2022.DTOs.ReservationDTO;
import unesp.lcp.LCP2022.models.Reservation;
import unesp.lcp.LCP2022.repositories.CustomerRepository;
import unesp.lcp.LCP2022.repositories.ReservationRepository;
import unesp.lcp.LCP2022.repositories.RoomRepository;
import unesp.lcp.LCP2022.services.ReservationService;

/**
 *
 * @author Bruno
 */
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Override
    public Reservation reservateRoom(ReservationDTO reservationDTO){
        var customer = customerRepository.findById(reservationDTO.getCustomerCPF());
        var room = roomRepository.findById(reservationDTO.getRoomId());
        if (customer.isEmpty() || room.isEmpty()){
            /*
            TODO: Dar um erro com a mensagem explicativa para o front
            */
            return null;
        }
        
        /*
        TODO: verificar se o quarto está disponível
        */
        
        var reservation = Reservation.builder()
                .customer(customer.get())
                .checkinDate(reservationDTO.getStartDate())
                .daysReserved(reservationDTO.getDays())
                .discount(0)
                .room(room.get())
                .price(room.get().getBasePricePerDay())
                .build();
        
        return reservationRepository.save(reservation);
    }  
}
