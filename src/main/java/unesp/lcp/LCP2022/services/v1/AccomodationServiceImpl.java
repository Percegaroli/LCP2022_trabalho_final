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
import unesp.lcp.LCP2022.models.Accomodation;
import unesp.lcp.LCP2022.models.AccomodationKey;
import unesp.lcp.LCP2022.models.Customer;
import unesp.lcp.LCP2022.models.Reservation;
import unesp.lcp.LCP2022.repositories.AccomodationRepository;
import unesp.lcp.LCP2022.services.AccomodationService;

/**
 *
 * @author brunopercegaroli
 */
@Service
public class AccomodationServiceImpl implements AccomodationService {
    @Autowired
    private AccomodationRepository accomodationRepository;
    
    @Override
    public Optional<Accomodation> findAccomodationByCustomerCPF(String cpf){
        return accomodationRepository
                    .findAllByCustomerCpfAndCheckoutDateIsNull(cpf)
                    .stream()
                    .findFirst();
    }
    
    @Override
    public Accomodation saveAccomodation(Customer customer, Date checkinDate, Reservation reservation) {
        AccomodationKey id = new AccomodationKey();
        var accomodation = Accomodation.builder()
                .id(id)
                .customer(customer)
                .checkinDate(checkinDate)
                .reservation(reservation)
                .build();
        
        return accomodationRepository.save(accomodation);
    }

    @Override
    public Optional<Accomodation> makeCheckout(String cpf, long reservationId){
        var accomodation = accomodationRepository.findByCustomerCpfAndReservationId(cpf, reservationId);
        if (accomodation.isPresent()){
            accomodation.get().setCheckoutDate(new Date());
            accomodationRepository.save(accomodation.get());
            return accomodation;
        }
        return null;
    }
    
    @Override
    public List<Integer> getDaysAccomodation(Optional<Accomodation> Acc, int daysReserved){
        int i;
        Date data;
        List<Integer> diasHospedado = new ArrayList<Integer>();
        data = Acc.get().getCheckinDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        if(cal.get(Calendar.MONTH) == 7){
            for(i=0; i<daysReserved; i++){
                diasHospedado.add(dia + i);
            }
        }
        return diasHospedado;
    }
}
