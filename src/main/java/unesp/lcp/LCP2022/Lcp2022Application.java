package unesp.lcp.LCP2022;

import java.awt.EventQueue;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import unesp.lcp.LCP2022.forms.Inicia;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Lcp2022Application {
	public static void main(String[] args) {
            ConfigurableApplicationContext context = new SpringApplicationBuilder(Lcp2022Application.class).headless(false).run(args);
             EventQueue.invokeLater(() -> {
                Inicia ex = context.getBean(Inicia.class);
                ex.setVisible(true);
            });
	}

}
