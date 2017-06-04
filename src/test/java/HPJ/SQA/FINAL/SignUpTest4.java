package HPJ.SQA.FINAL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SignUpTest4 {

	AccountSystem accountSystem;
	String userdata = " ";
		
	@Before
	public void setUp() throws Exception {
		accountSystem = AccountSystem.instance();
	}

	@Test
	public void test1() {
		assertFalse( accountSystem.apVerification("XYZQ123","Abcd1234") );
		
		accountSystem.signup("XYZQ123", "Abcd1234", userdata);
		assertTrue( accountSystem.apVerification("XYZQ123","Abcd1234") );
		assertTrue( accountSystem.apVerification("xyzq123","Abcd1234") );
		assertTrue( accountSystem.apVerification("xyZq123","Abcd1234") );
		
		assertFalse( accountSystem.apVerification("XYZQ123","ABcd1234") );
	}

}
