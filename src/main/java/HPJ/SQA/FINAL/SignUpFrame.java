package HPJ.SQA.FINAL;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SignUpFrame extends JFrame {
	
	AccountSystem accountSystem = AccountSystem.instance();
	
	private JTextField nameField = new JTextField(25);
	private JTextField accountField = new JTextField(25);
    private JPasswordField passwordField = new JPasswordField(25);
    private JPasswordField passwordField2 = new JPasswordField(20);
    private JComboBox<Integer> monthComboBox = new JComboBox<Integer>();
    private JComboBox<Integer> dateComboBox = new JComboBox<Integer>();
    private JButton signupButton = new JButton("註冊");
	
	public SignUpFrame() {
		super("註冊帳號");
		
		this.layoutFrame();
		this.setButtonListener();
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
	}
	
	private void layoutFrame() {
		
		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("名字："), BorderLayout.WEST);
		namePanel.add(nameField, BorderLayout.CENTER);
		
		JPanel accountPanel = new JPanel();
		accountPanel.add(new JLabel("帳號："), BorderLayout.WEST);
		accountPanel.add(accountField, BorderLayout.CENTER);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.add(new JLabel("密碼："), BorderLayout.WEST);
		passwordPanel.add(passwordField, BorderLayout.CENTER);
		
		JPanel passwordPanel2 = new JPanel();
		passwordPanel2.add(new JLabel("再輸入一次密碼："), BorderLayout.WEST);
		passwordPanel2.add(passwordField2, BorderLayout.CENTER);
		

	    for( int m=1 ; m<=12 ; m++ ) {
	    	monthComboBox.addItem(m);
	    }
	    for( int d=1 ; d<=31 ; d++ ) {
    		dateComboBox.addItem(d);
	    }
		JPanel birthdayPanel = new JPanel();
		birthdayPanel.add(new JLabel("生日："));
		birthdayPanel.add(monthComboBox);
		birthdayPanel.add(new JLabel("月"));
		birthdayPanel.add(dateComboBox);
		birthdayPanel.add(new JLabel("日"));
		
		JPanel tempPanel = new JPanel(new GridLayout(5, 1));
		tempPanel.add(accountPanel);
		tempPanel.add(passwordPanel);
		tempPanel.add(passwordPanel2);
		tempPanel.add(namePanel);
		tempPanel.add(birthdayPanel);

		this.add(tempPanel, BorderLayout.CENTER);
		this.add(signupButton, BorderLayout.SOUTH);
	}
	
	private void setButtonListener() {
		
		monthComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            	int month = (Integer) monthComboBox.getSelectedItem();
            	dateComboBox.removeAllItems();
            	for( int d=1 ; d<=days[month-1] ; d++ ) {
            		dateComboBox.addItem(d);
        	    }
            }
        } );
		
		signupButton.addActionListener( new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {
            	
            	String name = nameField.getText();
            	String account = accountField.getText();
            	String password = new String( passwordField.getPassword() );
            	String password2 = new String( passwordField2.getPassword() );
            	int month = (Integer) monthComboBox.getSelectedItem();
            	int date = (Integer) dateComboBox.getSelectedItem();
            	
            	if( name.equals("") || account.equals("") || password.equals("") ) {
            		JOptionPane.showMessageDialog(null, "資料未填寫完成", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
            		return;
            	}
            	if( !password.equals(password2) ) {
            		JOptionPane.showMessageDialog(null, "兩次密碼輸入不同", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
            		return;
            	}
            	
            	String personalData = name + "-" + month + "-" + date;
            	// System.out.println( personalData );
            	String signUpMessage = accountSystem.signup(account, password, personalData);
            	// System.out.println( signUpMessage );
            	if( signUpMessage.equals(AccountSystem.s1) ) {
            		JOptionPane.showMessageDialog(null, account.toLowerCase() + " 註冊成功");
            		setFrameVisible(false);
            	} else {
            		JOptionPane.showMessageDialog(null, signUpMessage, "錯誤訊息", JOptionPane.ERROR_MESSAGE);
            	}
                
            }
        } );
		
	}
	
	public void setFrameVisible(boolean b) {
		this.setVisible(b);
	}
	
}
