/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import unesp.lcp.LCP2022.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>  {
    public List<Hotel> findAllByName(String name);
}
