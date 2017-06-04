package HPJ.SQA.FINAL;

import java.util.HashMap;

public class AccountSystem implements AccountAvailable, PasswordAvailable, AccountVerification {
		
	public static String s1 = "Sucess";
	public static String s2 = "帳號已經存在";
	public static String s3 = "帳號不符合要求（長度介於6~20、包含英文與數字、不能有特殊符號）";
	public static String s4 = "密碼不符合要求（長度介於8~20、包含英文大小寫與數字、不可有特殊符號）";
	
	private static AccountSystem accountSystem = null;
	private HashMap<String, String> accountPassword = new HashMap<String, String>();
	private HashMap<String, String> otherData = new HashMap<String, String>();
	
	public static AccountSystem instance() {
		if( accountSystem == null ) {
			accountSystem = new AccountSystem();
		}
		return accountSystem;
	}
	
	private AccountSystem() {}
	
	public String signup(String account, String password, String data) {
		
		String lcAccount = account.toLowerCase();
				
		if( accountPassword.containsKey(lcAccount) )
			return AccountSystem.s2;
		if( !accountOK(lcAccount) )
			return AccountSystem.s3;
		if( !passwordOK(password) )
			return AccountSystem.s4;
		
		accountPassword.put(lcAccount, password);
		otherData.put(lcAccount, data);
		return AccountSystem.s1;
	}

	public boolean accountOK(String account) {
		if( account.length() >= 6 && account.length() <= 20 ) {	
			String regex = "[a-zA-Z0-9]+$";
			if( account.matches(regex) ) {
				boolean haveLetter = false;
				boolean havaDigit = false;
				for( int i=0 ; i<account.length() ; i++ ) {
					char temp = account.charAt(i);
					if( Character.isLetter(temp) )
						haveLetter = true;
					if( Character.isDigit(temp) )
						havaDigit = true;
				}
				if( haveLetter && havaDigit ) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean passwordOK(String password) {
		if( password.length() >= 8 && password.length() <= 20 ) {	
			String regex = "[a-zA-Z0-9]+$";
			if( password.matches(regex) ) {
				boolean haveUppercase = false;
				boolean haveLowercase = false;
				boolean havaDigit = false;
				for( int i=0 ; i<password.length() ; i++ ) {
					char temp = password.charAt(i);
					if( Character.isUpperCase(temp) )
						haveUppercase = true;
					if( Character.isLowerCase(temp) )
						haveLowercase = true;
					if( Character.isDigit(temp) )
						havaDigit = true;
				}
				if( haveUppercase && haveLowercase && havaDigit ) {
					return true;
				}
			}
		} 
		return false;	
	}
	
	public boolean apVerification(String account, String password) {
		String lcAccount = account.toLowerCase();
		if( accountPassword.containsKey(lcAccount) ) {
			if( accountPassword.get(lcAccount).equals(password) ) {
				return true;
			}
		}
		return false;
	}
	
	public boolean changePassword(String account, String newPassword, String data) {
		String lcAccount = account.toLowerCase();
		if( otherData.containsKey(lcAccount) ) {
			if( otherData.get(lcAccount).equals(data) ) {
				if( passwordOK(newPassword) ) {
					accountPassword.replace(lcAccount, newPassword);
					return true;
				}
			}
		}
		return false;
	}
	
}
