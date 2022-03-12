package testing;
import static org.junit.Assert.*;

import org.junit.Test;

import shuff.Credits;
public class CreditsTest {
	@Test(timeout = 10000)
	public void Konstruktor(){
		Credits c = new Credits(124, 5, 6);
		assertEquals(124,c.getTimeInSeconds());
		assertEquals("2:4",c.getTime());
		assertEquals(5,c.getMoves());
		assertEquals(6,c.getLevel());
	}
	@Test(timeout = 10000)
	public void KonstruktorNulaSekunde(){
		Credits c = new Credits(0, 5, 6);
		assertEquals(0,c.getTimeInSeconds());
		assertEquals("",c.getTime());
		
	}
	@Test(timeout = 10000)
	public void Player(){
		Credits c = new Credits(124, 5, 6);
		c.setPlayer("Pera");
		assertEquals("Pera",c.getPlayer());
	}
	@Test(timeout = 10000)
	public void NemaPlayer(){
		Credits c = new Credits(124, 5, 6);
		assertEquals("",c.getPlayer());
	}
	@Test(timeout = 10000)
	public void UporedjivanjePrvoVece(){
		Credits c = new Credits(124, 5, 6);
		Credits c1 = new Credits(111, 5, 6);
		assertEquals(1,c.compareTo(c1));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeDrugoVece(){
		Credits c = new Credits(124, 5, 6);
		Credits c1 = new Credits(151, 5, 6);
		assertEquals(-1,c.compareTo(c1));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeJednakoPrviMoveVeci(){
		Credits c = new Credits(124, 6, 6);
		Credits c1 = new Credits(124, 5, 6);
		assertEquals(1,c.compareTo(c1));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeJednakoDrugiiMoveVeci(){
		Credits c = new Credits(124, 6, 6);
		Credits c1 = new Credits(124, 7, 6);
		assertEquals(-1,c.compareTo(c1));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeJednakoSve(){
		Credits c = new Credits(124, 6, 6);
		Credits c1 = new Credits(124, 6, 6);
		assertEquals(0,c.compareTo(c1));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeDecimalnoPrviVeci(){
		Credits c = new Credits(124, 6, 6);
		assertEquals(1,c.compare(21.2, 5.1));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeDecimalnoDrugiVeci(){
		Credits c = new Credits(124, 6, 6);
		assertEquals(-1,c.compare(2.2, 5.4));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeDecimalnoJednoko(){
		Credits c = new Credits(124, 6, 6);
		assertEquals(0,c.compare(21.2, 21.2));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeintPrviVeci(){
		Credits c = new Credits(124, 6, 6);
		assertEquals(1,c.compare(21, 5));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeIntDrugiVeci(){
		Credits c = new Credits(124, 6, 6);
		assertEquals(-1,c.compare(2, 5));
	}
	@Test(timeout = 10000)
	public void UporedjivanjeIntJednoko(){
		Credits c = new Credits(124, 6, 6);
		assertEquals(0,c.compare(21, 21));
	}
	
}
