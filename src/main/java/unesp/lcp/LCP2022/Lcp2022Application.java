package unesp.lcp.LCP2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class TesteSwing extends JFrame{
	
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
	}
	
	private static void validaLogin(String logText, String passText) {
				
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

@SpringBootApplication
public class Lcp2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Lcp2022Application.class, args);
                System.setProperty("java.awt.headless", "false");
                TesteSwing ex1 = new TesteSwing(); 
		ex1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ex1.setSize(600, 100); 
		ex1.setVisible(true);
	}

}
