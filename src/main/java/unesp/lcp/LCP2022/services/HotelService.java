/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services;

import java.util.List;
import java.util.Optional;
import unesp.lcp.LCP2022.models.Hotel;

/**
 *
 * @author Bruno
 */
public interface HotelService {
    public Optional<Hotel> getHotelById(Long id);
    public Hotel createNewHotel(Hotel hotel);
    public List<Hotel> listHotels();
    public List<Hotel> getHotelsByName(String name);
}
