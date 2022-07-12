/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;
    
    @Column(length = 8)
    private String cep;
    
    @Column
    private String number;
    
    @Column(length = 11)
    private String phoneNumber;
    
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
    
    @ManyToMany
    @JoinTable(
            name="supplied_services",
            joinColumns = @JoinColumn(name="hotel_id"),
            inverseJoinColumns = @JoinColumn(name="service_id")
    )
    private List<Service> suppliedServices;
}
