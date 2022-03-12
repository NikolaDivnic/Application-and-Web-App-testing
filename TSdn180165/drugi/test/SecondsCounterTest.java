package testing;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized.Parameters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import org.junit.Ignore;
import org.junit.Test;

import shuff.SecondsCounter;;;
public class SecondsCounterTest {
	@Test(timeout = 10000)
	public void Konstruktor(){
		SecondsCounter c = new SecondsCounter();
		
		assertEquals(1000,c.timer_.getDelay());
		assertEquals(0,c.counter);
	}
	@Test(timeout = 10000)
	public void setLabel(){
		SecondsCounter c = new SecondsCounter();
		
		c.setLabel(new JLabel("123"));
		assertEquals("123",c.secondsCounterLabel.getText());
	}
	@Test(timeout = 10000)
	public void initCounter(){
		SecondsCounter c = new SecondsCounter();
		c.counter = 5;
		assertEquals(5,c.counter);
		c.initCounter();
		assertEquals(0,c.counter);
	}
	@Test(timeout = 10000)
	public void restart(){
		SecondsCounter c = new SecondsCounter();
		c.counter = 5;
		assertEquals(5,c.counter);
		c.setLabel(new JLabel("123"));
		c.reStart();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		assertEquals(2,c.counter);
	}
	@Test(timeout = 10000 , expected = NullPointerException.class)
	public void startBezLabele(){
		SecondsCounter c = new SecondsCounter();
		c.counter = 5;
		assertEquals(5,c.counter);
		c.start();
		assertEquals(2,c.counter);
		
	}
	@Test(timeout = 10000)
	public void start2BezLabele() throws InterruptedException{
		SecondsCounter c = new SecondsCounter();
		c.counter = 5;
		assertEquals(5,c.counter);
		c.start2();
		
			Thread.sleep(3000);
		
		assertEquals(2,c.counter);
		//Dodati metodu
				/*public void start2(){
		    	if (secondsCounterLabel == null){
		    		secondsCounterLabel = new JLabel();
		    	}
		    	start();}*/
		//u osnovnoj klasi da bi se naglasilo programerima
    
	}
	@Test(timeout = 10000)
	public void pause(){
		SecondsCounter c = new SecondsCounter();
		c.setLabel(new JLabel("123"));
		c.counter = 5;
		assertEquals(5,c.counter);
		
		c.pause();
		assertEquals(false,c.timer_.isRunning());
		assertEquals(5,c.counter);
	}
	@Test(timeout = 10000)
	public void enable(){
		SecondsCounter c = new SecondsCounter();
		c.setLabel(new JLabel("123"));
		c.counter = 5;
		assertEquals(5,c.counter);
		
		c.enable();
		assertEquals(true,c.timer_.isRunning());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		assertEquals(7,c.counter);
	}
	@Test(timeout = 10000)
	public void stop(){
		SecondsCounter c = new SecondsCounter();
		c.setLabel(new JLabel("123"));
		c.counter = 5;
		assertEquals(5,c.counter);
		
		c.stop();
		assertEquals(false,c.timer_.isRunning());
		assertEquals(0,c.counter);
	}
	@Test(timeout = 10000)
	public void getTimeElapsedInSeconds(){
		SecondsCounter c = new SecondsCounter();
		c.counter = 5;
		assertEquals(5,c.getTimeElapsedInSeconds());
	}
	
	
	
	
	
	
	
	@Test(timeout = 10000)
	public void getTimeElapsedPrekoDesetMinuta(){
		SecondsCounter c = new SecondsCounter();
		c.counter = 779;
		assertEquals("12 Minutes & 59 Seconds ",c.getTimeElapsed());
		c.counter = 700;
		assertEquals("11 Minutes & 40 Seconds ",c.getTimeElapsed());
		c.counter = 605;
		assertEquals("10 Minutes & 05 Seconds ",c.getTimeElapsed());
		c.counter = 600;
		assertEquals("10 Minutes & 00 Seconds ",c.getTimeElapsed());
	}
	
	
	@Test(timeout = 10000)
	public void getTimeElapsedPrekoMinut(){
		SecondsCounter c = new SecondsCounter();
		c.counter = 75;
		assertEquals("01 Minutes & 15 Seconds ",c.getTimeElapsed());
		/*c.counter = 70;
		assertEquals("01 Minutes & 10 Seconds ",c.getTimeElapsed());
		c.counter = 65;
		assertEquals("01 Minutes & 05 Seconds ",c.getTimeElapsed());
		c.counter = 60;
		assertEquals("01 Minutes & 00 Seconds ",c.getTimeElapsed());*/
	}
	@Test(timeout = 10000)
	public void getTimeElapsedManjeMinut(){
		SecondsCounter c = new SecondsCounter();
		c.counter = 15;
		assertEquals("00 Minutes & 15 Seconds ",c.getTimeElapsed());
		c.counter = 10;
		assertEquals("00 Minutes & 10 Seconds ",c.getTimeElapsed());
		c.counter = 5;
		assertEquals("00 Minutes & 05 Seconds ",c.getTimeElapsed());
		c.counter = 0;
		assertEquals("00 Minutes & 00 Seconds ",c.getTimeElapsed());
	}
	@Test(timeout = 10000)
	public void getMinitueStringPrekoDestMinuta(){
		SecondsCounter c = new SecondsCounter();
		assertEquals("12 : 59",c.getMinitueString(779));
		assertEquals("12 : 59",c.text_.toString());
		assertEquals("11 : 40",c.getMinitueString(700));
		assertEquals("11 : 40",c.text_.toString());
		assertEquals("10 : 10",c.getMinitueString(610));
		assertEquals("10 : 10",c.text_.toString());
		assertEquals("10 : 05",c.getMinitueString(605));
		assertEquals("10 : 05",c.text_.toString());
		assertEquals("10 : 00",c.getMinitueString(600));
		assertEquals("10 : 00",c.text_.toString());
	}
	@Test(timeout = 10000)
	public void getMinitueStringPrekoMinut(){
		SecondsCounter c = new SecondsCounter();
		assertEquals("01 : 17",c.getMinitueString(77));
		/*assertEquals("01 : 17",c.text_.toString());
		assertEquals("01 : 10",c.getMinitueString(70));
		assertEquals("01 : 10",c.text_.toString());
		assertEquals("01 : 05",c.getMinitueString(65));
		assertEquals("01 : 05",c.text_.toString());
		assertEquals("01 : 00",c.getMinitueString(60));
		assertEquals("01 : 00",c.text_.toString());*/
	}
	@Test(timeout = 10000)
	public void getMinitueStringManjeOdMinut(){
		SecondsCounter c = new SecondsCounter();
		assertEquals("00 : 17",c.getMinitueString(17));
		assertEquals("00 : 17",c.text_.toString());
		assertEquals("00 : 10",c.getMinitueString(10));
		assertEquals("00 : 10",c.text_.toString());
		assertEquals("00 : 05",c.getMinitueString(5));
		assertEquals("00 : 05",c.text_.toString());
		assertEquals("00 : 00",c.getMinitueString(0));
		assertEquals("00 : 00",c.text_.toString());
	}
	@Test(timeout = 10000)
	public void finalize(){
		SecondsCounter c = new SecondsCounter();
		c.finalize();
		assertEquals(null,c.timer_);
	}
}
