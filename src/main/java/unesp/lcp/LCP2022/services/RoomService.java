/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unesp.lcp.LCP2022.services;

import java.util.List;
import unesp.lcp.LCP2022.models.Room;

/**
 *
 * @author Lucas Ghisloti
 */
public interface RoomService {
    public Room createNewRoom(Room room);
    public List<Room> getRoomsByHotel(String hotel);
}
