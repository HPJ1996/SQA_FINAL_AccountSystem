package HPJ.SQA.FINAL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class SignUpTest1 {

	AccountAvailable accountAvailable;
	PasswordAvailable passwordAvailable;
	
	@Before
	public void setUp() throws Exception {
		accountAvailable = mock(AccountAvailable.class);
		passwordAvailable = mock(PasswordAvailable.class);
		
		when(accountAvailable.accountOK("ABC123")).thenReturn(true);
		when(accountAvailable.accountOK("ABC")).thenReturn(false);
		when(accountAvailable.accountOK("ABCDEFGHIJK1234567890")).thenReturn(false);
		when(accountAvailable.accountOK("ABC123!!!")).thenReturn(false);
		when(accountAvailable.accountOK("ABC123我")).thenReturn(false);
		when(accountAvailable.accountOK("ABCdefg")).thenReturn(false);
		when(accountAvailable.accountOK("1234567")).thenReturn(false);
		
		when(passwordAvailable.passwordOK("Abcd1234")).thenReturn(true);
		when(passwordAvailable.passwordOK("Abcd12")).thenReturn(false);
		when(passwordAvailable.passwordOK("abcd1234")).thenReturn(false);
		when(passwordAvailable.passwordOK("abcd1234!!")).thenReturn(false);
		when(passwordAvailable.passwordOK("abcd1234中文")).thenReturn(false);
	}

	@Test
	public void testAccount() {
		assertTrue( accountAvailable.accountOK("ABC123") );
		assertFalse( accountAvailable.accountOK("ABC") );
		assertFalse( accountAvailable.accountOK("ABCDEFGHIJK1234567890") );
		assertFalse( accountAvailable.accountOK("ABC123!!!") );
		assertFalse( accountAvailable.accountOK("ABC123我") );
		assertFalse( accountAvailable.accountOK("ABCdefg") );
		assertFalse( accountAvailable.accountOK("1234567") );
	}
	
	@Test
	public void testPassword() {
		assertTrue( passwordAvailable.passwordOK("Abcd1234") );
		assertFalse( passwordAvailable.passwordOK("Abcd12") );
		assertFalse( passwordAvailable.passwordOK("abcd1234") );
		assertFalse( passwordAvailable.passwordOK("abcd1234!!") );
		assertFalse( passwordAvailable.passwordOK("abcd1234中文") );
	}

}
