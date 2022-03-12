package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import shuff.Credits;

public class CreditsDouble {
	private Credits c = Mockito.mock(Credits.class);
	@Before
	public void podesavanje() {
		Mockito.when(c.compare(4.1, 2.1)).thenCallRealMethod();
		Mockito.when(c.compare(2.1, 4.1)).thenCallRealMethod();
		Mockito.when(c.compare(2.1, 2.1)).thenCallRealMethod();
	}
	
	@Test
	public void compareDoublePrviVeci() {	
		assertEquals(1,c.compare(4.1, 2.1));
	}
	@Test
	public void compareDoubleDrugiVeci() {
		assertEquals(-1,c.compare(2.1, 4.1));
	}
	@Test
	public void compareDoubleJednaki() {
		assertEquals(0,c.compare(2.1, 2.1));
	}
}
