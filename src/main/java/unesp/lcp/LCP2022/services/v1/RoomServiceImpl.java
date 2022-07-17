/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services.v1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import unesp.lcp.LCP2022.models.Hotel;
import unesp.lcp.LCP2022.models.Room;
import unesp.lcp.LCP2022.repositories.RoomRepository;
import unesp.lcp.LCP2022.services.RoomService;

/**
 *
 * @author Lucas Ghisloti
 */
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;
    
    @Override
    public Optional<Room> getRoomById(Long id) {
        return this.roomRepository.findById(id);
    }

    @Override
    public List<Room> getRoomsByHotel(Optional<Hotel> hotel){
        return this.roomRepository.findAllByHotel(hotel);
    }
}
