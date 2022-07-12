package unesp.lcp.LCP2022;

import java.awt.EventQueue;
import org.springframework.boot.SpringApplication;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import unesp.lcp.LCP2022.services.HotelService;

@Component
class TesteSwing extends JFrame{
        @Autowired
        private HotelService hotelService;
	
	private final JLabel label1 = new JLabel();
	private final JLabel label2 = new JLabel();
	private final JTextField fieldLogin; 
	private final JPasswordField passwordField;
	
	private static final String loginCerto = "usuario";
	private static final String senhaCerta = "senha";
	
	private static int tentativasSobrando = 5;
	
	public TesteSwing(){
		super("Acesso ao sistema");
		setLayout(new FlowLayout());
                		
		label1.setText("Login: ");
		add(label1);
		fieldLogin = new JTextField(10);
		add(fieldLogin);
		
		label2.setText("Senha: ");
		add(label2);
		passwordField = new JPasswordField("",20);
		add(passwordField);
		
		loginHandler handler = new loginHandler();
		fieldLogin.addActionListener(handler);
		passwordField.addActionListener(handler);
		
		setVisible(true);
                setSize(600, 100);
	}
	
	private void validaLogin(String logText, String passText) {
                var hotel = hotelService.getHotelById(1L);
                if (hotel.isPresent()){
                    System.out.printf("%s", hotel.get().getName());
                }else {
                    System.out.println("Deu merda");
                }
				
		if (logText.equals(loginCerto) && passText.equals(senhaCerta)) {
			JOptionPane.showMessageDialog(null, "Senha válida!");
			System.exit(1);
		}else {
			tentativasSobrando--;
		}
		if (tentativasSobrando > 0) {
			JOptionPane.showMessageDialog(null, String.format("Senha inválida, você tem mais %d tentativas.", tentativasSobrando), "Acesso Negado!", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Acesso inválido. Clique para sair.");
			System.exit(1);
		}		
	}

        /*
    @Override
    public void run(String... args) throws Exception {
         try {
            TesteSwing frame = new TesteSwing();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
	
	private class loginHandler implements ActionListener {
    
		@Override
		public void actionPerformed(ActionEvent event) {
            if (event.getSource() == fieldLogin)
            	passwordField.requestFocus();
            else if (event.getSource() == passwordField) {
            	validaLogin(fieldLogin.getText(), String.format("%s", event.getActionCommand()));
            }
		}
	}
}

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Lcp2022Application {
	public static void main(String[] args) {
            ConfigurableApplicationContext context = new SpringApplicationBuilder(Lcp2022Application.class).headless(false).run(args);
             EventQueue.invokeLater(() -> {
                TesteSwing ex = context.getBean(TesteSwing.class);
                ex.setVisible(true);
            });
	}

}
