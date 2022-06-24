/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
class ConsumedProductKey implements Serializable {
    // referenciar o accomodation
    
    @Column(name = "product_id")
    private Long productId;
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumedProduct implements Serializable {
    @EmbeddedId
    ConsumedProductKey id;
    
    @Column
    private double value;
    
    @Column
    private Date orderDate;
    
}
