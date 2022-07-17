/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unesp.lcp.LCP2022.services;

import java.util.List;
import java.util.Optional;
import unesp.lcp.LCP2022.models.Hotel;
import unesp.lcp.LCP2022.models.Room;

/**
 *
 * @author Lucas Ghisloti
 */
public interface RoomService {
    public Optional<Room> getRoomById(Long id);
    public List<Room> getRoomsByHotel(Optional<Hotel> hotel);
}
