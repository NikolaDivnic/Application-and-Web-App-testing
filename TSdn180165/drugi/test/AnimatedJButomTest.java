package testing;
import static org.junit.Assert.*;

import java.awt.event.MouseEvent;

import org.junit.Ignore;
import org.junit.Test;

import shuff.AnimatedJButton;;
public class AnimatedJButomTest {
	@Test(timeout = 10000)
	public void Konstruktor(){
		AnimatedJButton c = new AnimatedJButton("aa", 321);
		
		assertEquals("aa",c.dohvatiText());
		assertEquals(321,c.getTextGap_());
		assertEquals(100,c.getTimer().getDelay());
	}
	@Test(timeout = 10000)
	public void postaviIme(){
		AnimatedJButton c = new AnimatedJButton("aa", 321);
		c.setLabelName("ime");
		assertEquals("ime",c.text);
	}
	@Test(timeout = 10000)
	public void petljaNista(){
		assertEquals("",AnimatedJButton.getString("", 0));
	}
	@Test(timeout = 10000)
	public void petljaNulaJedan(){
		assertEquals("",AnimatedJButton.getString("", 1));
	}
	@Test(timeout = 10000)
	public void petljaJedanJedan(){
		assertEquals("a",AnimatedJButton.getString("a", 1));
	}
	@Test(timeout = 10000)
	public void petljaJedanNula(){
		assertEquals("a",AnimatedJButton.getString("a", 0));
	}
	@Test(timeout = 10000)
	public void petljaPetNula(){
		assertEquals("abcde",AnimatedJButton.getString("abcde", 0));
	}
	@Test(timeout = 10000)
	public void petljaPetJedan(){
		assertEquals("a b c d e",AnimatedJButton.getString("abcde", 1));
	}
	@Test(timeout = 10000)
	public void petljaPetPet(){
		assertEquals("a     b     c     d     e",AnimatedJButton.getString("abcde", 5));
	}
	
}
