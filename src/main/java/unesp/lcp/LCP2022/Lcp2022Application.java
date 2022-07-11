package unesp.lcp.LCP2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import unesp.lcp.LCP2022.forms.Inicia;


@SpringBootApplication
public class Lcp2022Application {
    
	public static void main(String[] args) {
            Inicia inicio = new Inicia();
            inicio.setVisible(true);
            SpringApplication.run(Lcp2022Application.class, args);
	}

}
