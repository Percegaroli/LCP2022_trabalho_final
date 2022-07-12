/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services.v1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.lcp.LCP2022.models.Room;
import unesp.lcp.LCP2022.repositories.RoomRepository;
import unesp.lcp.LCP2022.services.RoomService;

/**
 *
 * @author Lucas Ghisloti
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createNewRoom(Room room) {
        return this.roomRepository.save(room);
    }

    @Override
    public List<Room> getRoomsByHotel(String hotelName) {
        return this.roomRepository.findAllByHotel(hotelName);
    }
}
