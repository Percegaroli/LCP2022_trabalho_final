/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.DTOs;

import java.util.Date;
import lombok.Data;

@Data
public class ReservationDTO {
    private String customerCPF;
    
    private Long roomId;
    
    private int days;
    
    private Date startDate;
}
