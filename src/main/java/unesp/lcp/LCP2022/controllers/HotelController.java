/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import unesp.lcp.LCP2022.models.Hotel;
import unesp.lcp.LCP2022.models.Room;
import unesp.lcp.LCP2022.services.v1.HotelServiceImpl;
import unesp.lcp.LCP2022.services.v1.RoomServiceImpl;

/**
 *
 * @author Bruno
 */
@RestController
public class HotelController {   
    @Autowired
    private HotelServiceImpl hotelServicos;
    
    @Autowired
    private RoomServiceImpl roomServicos;
    
    @PostMapping
    public void carregaHoteis(){
        Hotel hotel = new Hotel();
        List<Room> listaQuartos;
        hotel.setName("Mãe Preta's Palace");
        hotel.setCity("Rio Claro");
        hotel.setCategory(2);
        hotel.setCep("06626080");
        hotel.setNumber("3598");
        hotel.setPhoneNumber("4002-8922");
        listaQuartos = carregaQuartos(hotel);
        hotel.setRooms(listaQuartos);
        hotelServicos.createNewHotel(hotel);
    }
    
    @PostMapping
    public List<Room> carregaQuartos(Hotel hotel){
        Room room = new Room();
        room.setHotel(hotel);
        room.setFloor(1);
        room.setCapacity(2);
        room.setBasePricePerDay((float) 58.99);
        room.setAvaliable(true);
        roomServicos.createNewRoom(room);
        room.setHotel(hotel);
        room.setFloor(2);
        room.setCapacity(1);
        room.setBasePricePerDay((float) 35.99);
        room.setAvaliable(false);
        roomServicos.createNewRoom(room);
        room.setHotel(hotel);
        room.setFloor(3);
        room.setCapacity(4);
        room.setBasePricePerDay((float) 105.99);
        room.setAvaliable(true);
        roomServicos.createNewRoom(room);
        return roomServicos.getRoomsByHotel(hotel.getName());
    }
    
    @RequestMapping("/")
    @ResponseBody
    public List<Hotel> verHoteis(){
        List<Hotel> hoteis;
        hoteis = hotelServicos.listHotels();
        return hoteis; 
    }
}
