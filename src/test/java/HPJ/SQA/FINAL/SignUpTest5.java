package HPJ.SQA.FINAL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SignUpTest5 {

	AccountSystem accountSystem;
	String userdata = " ";
		
	@Before
	public void setUp() throws Exception {
		accountSystem = AccountSystem.instance();
	}

	@Test
	public void test1() {		
		accountSystem.signup("XYZQ123", "Abcd1234", userdata);
		assertTrue( accountSystem.changePassword("XYZQ123","Xyz12345", userdata) );
		assertTrue( accountSystem.changePassword("XYzQ123","Xyz12345", userdata) );
		assertTrue( accountSystem.changePassword("xyzq123","Xyz12345", userdata) );

		assertTrue( accountSystem.apVerification("xyzq123","Xyz12345") );
		assertTrue( accountSystem.apVerification("xyZq123","Xyz12345") );
		
		assertFalse( accountSystem.apVerification("XYZQ123","XyZ12345") );
		assertFalse( accountSystem.apVerification("XYZQ123","Abcd1234") );
	}
	
	@Test
	public void test2() {		
		accountSystem.signup("XYZQ123", "Abcd1234", userdata);
		assertFalse( accountSystem.changePassword("XYZQ123","Xyz12345", "Hahaha") );
	}

}
