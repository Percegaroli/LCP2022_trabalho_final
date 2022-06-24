/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    private String cpf;
    
    @Column
    private String name;
    
    @Column(length = 8)
    private String cep;
    
    @Column
    private String number;
    
    
    @Column(length = 15)
    private String phone;
    
    @Column
    private Date birthDate;
    
    @Column(length = 50)
    private String email;
}
