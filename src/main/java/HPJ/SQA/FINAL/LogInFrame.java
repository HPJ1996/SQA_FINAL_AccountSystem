package HPJ.SQA.FINAL;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class LogInFrame extends JFrame {
	
	AccountSystem accountSystem = AccountSystem.instance();
	SignUpFrame signupFrame = new SignUpFrame();
	ForgetPasswordFrame forgetPasswordFrame = new ForgetPasswordFrame();
	    
    private JTextField accountField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    
    private JButton enterButton = new JButton("確定");
    private JButton signUpButton = new JButton("註冊");
    private JButton forgetButton = new JButton("忘記密碼");
    	
	public LogInFrame() {
		super("登入");
		
		this.layoutFrame();
		this.setButtonListener();
		
		this.setSize(350, 130);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
	}
	
	private void layoutFrame() {
		
		JPanel accountPanel = new JPanel();
		accountPanel.add(new JLabel("帳號："), BorderLayout.WEST);
		accountPanel.add(accountField, BorderLayout.CENTER);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.add(new JLabel("密碼："), BorderLayout.WEST);
		passwordPanel.add(passwordField, BorderLayout.CENTER);
		
		JPanel tempPanel1 = new JPanel(new BorderLayout());
		tempPanel1.add(accountPanel, BorderLayout.NORTH);
		tempPanel1.add(passwordPanel, BorderLayout.SOUTH);
		
		JPanel tempPanel2 = new JPanel();
		tempPanel2.add(signUpButton);
		tempPanel2.add(forgetButton);
		tempPanel2.add(enterButton);
		
		this.add(tempPanel1, BorderLayout.CENTER);
		this.add(tempPanel2, BorderLayout.SOUTH);
	}
	
	private void setButtonListener() {
				
		enterButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// System.out.println("確認");
            	String account = accountField.getText();
            	String password = new String( passwordField.getPassword() );
            	
            	// System.out.println("Account = " + account + " 密碼 = " + password);
            	if( accountSystem.apVerification(account, password) ) {
            		accountField.setText("");
                	passwordField.setText("");
                	JOptionPane.showMessageDialog(null, account.toLowerCase() + "登入成功！");
            	} else {
            		passwordField.setText("");
            		JOptionPane.showMessageDialog(null, "登入失敗！", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
            	}
            }
        } );
		
		signUpButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// System.out.println("註冊");
            	signupFrame.setVisible(true);
            }
        } );
		
		forgetButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// System.out.println("忘記密碼");
            	forgetPasswordFrame.setVisible(true);
            }
        } );
		
	}
	
}
