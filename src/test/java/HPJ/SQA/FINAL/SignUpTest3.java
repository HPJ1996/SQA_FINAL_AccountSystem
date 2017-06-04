package HPJ.SQA.FINAL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SignUpTest3 {

	AccountSystem accountSystem;
	String userdata = " ";
		
	@Before
	public void setUp() throws Exception {
		accountSystem = AccountSystem.instance();
	}

	@Test
	public void test1() {
		assertEquals( AccountSystem.s1, accountSystem.signup("XYZQ123", "Abcd1234", userdata) );
		assertEquals( AccountSystem.s1, accountSystem.signup("ABC1234", "Abcd1234", userdata) );
		assertEquals( AccountSystem.s1, accountSystem.signup("ABC123", "Abcd1234", userdata) );
		assertEquals( AccountSystem.s2, accountSystem.signup("ABC123", "Abcd1234", userdata) );
		assertEquals( AccountSystem.s2, accountSystem.signup("abc123", "Abcd1234", userdata) );
	}
	
	@Test
	public void test2() {
		assertEquals( AccountSystem.s3, accountSystem.signup("xyz12", "abcd1234", userdata) );
		assertEquals( AccountSystem.s3, accountSystem.signup("abcdefg", "abcd1234", userdata) );
		assertEquals( AccountSystem.s3, accountSystem.signup("1234567", "abcd1234", userdata) );
		assertEquals( AccountSystem.s3, accountSystem.signup("123456789abcdefghijklmnop", "abcd1234", userdata) );
	}
	
	@Test
	public void test3() {
		assertEquals( AccountSystem.s4, accountSystem.signup("xyz123", "12345678", userdata) );
		assertEquals( AccountSystem.s4, accountSystem.signup("xyz123", "abcdefghij", userdata) );
		assertEquals( AccountSystem.s4, accountSystem.signup("xyz123", "abcde12345", userdata) );
		assertEquals( AccountSystem.s4, accountSystem.signup("xyz123", "ABCDE12345", userdata) );
		assertEquals( AccountSystem.s4, accountSystem.signup("xyz123", "ABCDEFGHIJ", userdata) );
	}

}
