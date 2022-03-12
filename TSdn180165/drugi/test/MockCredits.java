package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import shuff.Credits;

public class MockCredits {

	
	private Credits c = Mockito.mock(Credits.class);
	@Before
	public void podesavanje() {
		Mockito.when(c.compare(4, 2)).thenCallRealMethod();
		Mockito.when(c.compare(2, 4)).thenCallRealMethod();
		Mockito.when(c.compare(2, 2)).thenCallRealMethod();
		Mockito.when(c.compare(4.1, 2.1)).thenCallRealMethod();
		Mockito.when(c.compare(2.1, 4.1)).thenCallRealMethod();
		Mockito.when(c.compare(2.1, 2.1)).thenCallRealMethod();
	}
	
	@Test
	public void compareIntPrviVeci() {
		assertEquals(1,c.compare(4, 2));
	}
	@Test
	public void compareIntDrugiVeci() {
		assertEquals(-1,c.compare(2, 4));
	}
	@Test
	public void compareIntIsti() {
		assertEquals(0,c.compare(2, 2));
	}
	
}