package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import shuff.SecondsCounter;

public class TestMock {

	
	private SecondsCounter c = Mockito.mock(SecondsCounter.class);
	
	@Before
	public void podesavanje() {
		
		Mockito.when(c.getMinitueString(779)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(700)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(610)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(605)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(600)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(17)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(10)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(5)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(0)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(77)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(70)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(65)).thenCallRealMethod();
		Mockito.when(c.getMinitueString(60)).thenCallRealMethod();
	}
	@Test(timeout = 10000)
	public void getMinitueStringPrekoDestMinuta(){
		assertEquals("12 : 59",c.getMinitueString(779));
		assertEquals("11 : 40",c.getMinitueString(700));
		assertEquals("10 : 10",c.getMinitueString(610));
		assertEquals("10 : 05",c.getMinitueString(605));
		assertEquals("10 : 00",c.getMinitueString(600));
	}
	
	@Test(timeout = 10000)
	public void getMinitueStringManjeOdMinut(){
		assertEquals("00 : 17",c.getMinitueString(17));
		assertEquals("00 : 10",c.getMinitueString(10));
		assertEquals("00 : 05",c.getMinitueString(5));
		assertEquals("00 : 00",c.getMinitueString(0));
	}
	@Test(timeout = 10000)
	public void getMinitueStringPrekoMinut(){
		assertEquals("01 : 17",c.getMinitueString(77));
		assertEquals("01 : 10",c.getMinitueString(70));
		assertEquals("01 : 05",c.getMinitueString(65));
		assertEquals("01 : 00",c.getMinitueString(60));
	}
	
	
	
}