/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.services;

import unesp.lcp.LCP2022.DTOs.ReservationDTO;
import unesp.lcp.LCP2022.models.Reservation;

/**
 *
 * @author Bruno
 */
public interface ReservationService {
     public Reservation reservateRoom(ReservationDTO reservationDTO);
}
