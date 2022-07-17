/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
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
    public Reservation reservateRoom(int roomID, String customerCPF, Date startDate, int accomodationDays){
        var customer = customerRepository.findById(customerCPF);
        var room = roomRepository.findById(roomID);
        var reservation = Reservation.builder()
                .customer(customer.get())
                .checkinDate(startDate)
                .daysReserved(accomodationDays)
                .discount(0)
                .room(room)
                .price(room.getBasePricePerDay())
                .build();
        return reservationRepository.save(reservation);
    }
    
    @Override
    public List<Reservation> getReservationByRoom(Optional<Room> room){
        return reservationRepository.findAllByRoom(room);
    }
    
    @Override
    public Boolean getRoomAvailability(List<Reservation> reservas, int diaReserva){
        int i;
        Date data = null;
        Boolean livre = true;
        List<Integer> diasReservados = new ArrayList<Integer>();
        var dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        for(var reserv: reservas){
            if(livre){
                var dataString = dateFormat.format(reserv.getCheckinDate());    
                try {
                    data = formato.parse(dataString);
                } catch (ParseException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                if(cal.get(Calendar.MONTH) == 6){
                    for(i=0; i<reserv.getDaysReserved(); i++){
                        diasReservados.add(dia + i);
                    }
                }
                if(diasReservados.contains(diaReserva)){
                    livre = false;
                }else
                    livre = true;
            }
        }
        return livre;
    }
    
    @Override
    public List<Reservation> getReservationByCustomer(Customer customer){
        return reservationRepository.findAllByCustomer(customer);
    }
}
