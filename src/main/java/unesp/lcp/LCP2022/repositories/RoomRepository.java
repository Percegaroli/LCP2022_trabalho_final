/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import unesp.lcp.LCP2022.models.Hotel;
import unesp.lcp.LCP2022.models.Room;

/**
 *
 * @author Bruno
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
    public List<Room> findAllByHotel(Optional<Hotel> hotel);
    public Room findById(long id);
}
