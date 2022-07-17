package unesp.lcp.LCP2022.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AccomodationKey implements Serializable {
    @Column(name = "customer_cpf")
    private String customerCpf;
    
    @Column(name = "reservation_id")
    private Long reservationId;
}