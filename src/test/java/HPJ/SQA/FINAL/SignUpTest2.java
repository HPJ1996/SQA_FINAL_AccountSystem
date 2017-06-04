package HPJ.SQA.FINAL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SignUpTest2 {

	AccountAvailable accountAvailable;
	PasswordAvailable passwordAvailable;
	
	@Before
	public void setUp() throws Exception {
		AccountSystem accountSystem = AccountSystem.instance();
		accountAvailable = accountSystem;
		passwordAvailable = accountSystem;
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
