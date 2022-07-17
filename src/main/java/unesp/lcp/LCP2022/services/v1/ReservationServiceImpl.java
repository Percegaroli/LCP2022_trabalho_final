/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services.v1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.lcp.LCP2022.DTOs.ReservationDTO;
import unesp.lcp.LCP2022.models.Customer;
import unesp.lcp.LCP2022.models.Reservation;
import unesp.lcp.LCP2022.models.Room;
import unesp.lcp.LCP2022.repositories.CustomerRepository;
import unesp.lcp.LCP2022.repositories.ReservationRepository;
import unesp.lcp.LCP2022.repositories.RoomRepository;
import unesp.lcp.LCP2022.services.ReservationService;

/**
 *
 * @author Bruno
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Override
    public List<Reservation> getReservationByCustomerAndDate(Customer customer, Date date){
        var reservations = this.reservationRepository.findByCustomerAndCheckinDate(customer, date);
        return reservations;
    }
    
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
    
    @Override
    public List<Reservation> getReservationByRoom(Optional<Room> room){
        return reservationRepository.findAllByRoom(room);
    }
    
    @Override
    public List<Integer> getDaysReservation(Reservation reserv){
        int i;
        Date data;
        List<Integer> diasReservados = new ArrayList<Integer>();
        data = reserv.getCheckinDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        if(cal.get(Calendar.MONTH) == 7){
            for(i=0; i<reserv.getDaysReserved(); i++){
                diasReservados.add(dia + i);
            }
        }
        return diasReservados;
    }
    
    @Override
    public List<Reservation> getReservationByCustomer(Customer customer){
        return reservationRepository.findAllByCustomer(customer);
    }
}
