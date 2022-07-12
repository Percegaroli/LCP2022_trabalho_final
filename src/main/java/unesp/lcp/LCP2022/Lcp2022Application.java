package unesp.lcp.LCP2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import unesp.lcp.LCP2022.forms.Inicia;
import unesp.lcp.LCP2022.controllers.HotelController;


@SpringBootApplication
public class Lcp2022Application {
    
	public static void main(String[] args) {
            HotelController carregaBD = new HotelController();
            carregaBD.carregaHoteis();
            Inicia inicio = new Inicia();
            SpringApplication.run(Lcp2022Application.class, args);
            inicio.setVisible(true);
	}

}
