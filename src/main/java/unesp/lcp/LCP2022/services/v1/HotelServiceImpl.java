/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services.v1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.lcp.LCP2022.models.Hotel;
import unesp.lcp.LCP2022.repositories.HotelRepository;
import unesp.lcp.LCP2022.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Optional<Hotel> getHotelById(Long id) {
        return this.hotelRepository.findById(id);
    }

    @Override
    public Hotel createNewHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> listHotels() {
        return this.hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getHotelsByName(String name) {
        return this.hotelRepository.findAllByName(name);
    }
    
    
}
