////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	 private static User user;

	    @BeforeClass
	    public static void beforeClass() {
	        user = new User("110","Daniele","Spigolon",21);
	    }

	    @Test
	    public void testId() {
	        assertEquals("110", user.getId());
	    }

	    @Test
	    public void testGetNome() {
	        assertEquals("Daniele", user.getNome());
	    }

	    @Test
	    public void testGetCognome() {
	        assertEquals("Spigolon", user.getCognome());
	    }
	    
	    @Test
	    public void testGetEta() {
	        assertEquals(21, user.getEta(), 0);
	    }
}
