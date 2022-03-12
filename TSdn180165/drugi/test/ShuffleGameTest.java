package testing;
import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import shuff.ShuffleGame;
public class ShuffleGameTest {
	ShuffleGame c = new ShuffleGame(4);
	@Test(timeout = 10000)
	public void Konstruktor(){
		assertEquals(4,c.getLevel());
		assertEquals(3,c.dohvatiBrojKomponenti());
		assertEquals(1000,c.brojacSekundi().timer_.getDelay());
	}
	@Test(timeout = 10000)
	public void getFooterPanel(){
	}
	@Test(timeout = 10000)
	public void init(){
		c.init(4);
		assertEquals(4,c.getLevel());
		assertEquals(16,c.dohvatiBrojCelija());
	}
	@Test(timeout = 10000)
	public void run(){
		ShuffleGame.run(5);
		assertEquals(5,ShuffleGame.dohvatiShufle().getLevel());
		ShuffleGame.run(4);
		assertEquals(4,ShuffleGame.dohvatiShufle().getLevel());
	}
	@Test(timeout = 10000)
	public void getPosition(){
		int pom = 0;
		int[] mat  = c.dohvatiMatricu();
		 for( int i = 0 ; i < 16 ; i++ )
	        {
	            if( mat[i] == 5 )
	            {
	                pom = i;
	            }
	        }
		assertEquals(pom,c.getPosition(5));
		pom =0 ;
		assertEquals(pom,c.getPosition(17));
	}
	@Test(timeout = 10000)
	public void startSecondsCounter(){
		c.startSecondsCounter();
		int pom = c.brojacSekundi().counter;
		try {Thread.sleep(1500);} catch (InterruptedException e) {}
		assertEquals(pom+1, c.brojacSekundi().counter);
		
	}
	@Test(timeout = 10000)
	public void changeGameStatus(){
		boolean pom = c.dohvatiStatusIgre();
		pom=!pom;
		c.setGameStatus(pom);;
		assertEquals(pom, c.dohvatiStatusIgre());
		pom =!pom;
		c.setGameStatus(pom);;
		assertEquals(pom, c.dohvatiStatusIgre());
	}
	
	@Test(timeout = 10000)
	public void changeButtonState(){
		c.changeButtonState(false);
		assertEquals(false, c.dohvatiStanjeDugmica());
		c.changeButtonState(true);
		assertEquals(true, c.dohvatiStanjeDugmica());
	}
	@Test(timeout = 10000)
	public void analyseResult(){
		int[] niz = new int[16];
		for (int i = 0;i<15;i++){
			niz[i] = i+1;
		}
		c.postaviMatricu(niz, 15);
		assertEquals(true, c.analyseResult());
		int pom = niz[0];
		niz[0] = niz[1];
		niz[1] = pom;
		c.postaviMatricu(niz, 15);
		assertEquals(false, c.analyseResult());
	}
	@Test(timeout = 10000)
	public void getComponentIfPossibleToMoveMoze(){
		int broj = c.nadjiPrazno(16);
		if(broj >11)
			assertEquals(true,c.getComponentIfPossibleToMove(broj-4)instanceof JLabel);
		if(broj % 4 >0)
			assertEquals(true,c.getComponentIfPossibleToMove(broj-1)instanceof JLabel);
		if(broj <=11)
			assertEquals(true,c.getComponentIfPossibleToMove(broj+4)instanceof JLabel);
		if(broj %4 <3)
			assertEquals(true,c.getComponentIfPossibleToMove(broj+1)instanceof JLabel);
	}
	@Test(timeout = 10000)
	public void getComponentIfPossibleToMoveNeMoze(){
		c.nadjiPrazno(-1);
		int broj = c.nadjiPrazno(16);
		int pom = 0;
		if(broj >7)
			pom = broj-8;
		else 
			pom = broj+8;
		assertEquals(false,c.getComponentIfPossibleToMove(pom)instanceof JLabel);
	}
	@Test(timeout = 10000)
	public void isPositionNotLeft(){
		assertEquals(false, c.isPositionNotLeft(0));
		assertEquals(true, c.isPositionNotLeft(6));
		assertEquals(false, c.isPositionNotLeft(4));
		assertEquals(true, c.isPositionNotLeft(15));
		assertEquals(false, c.isPositionNotLeft(12));

	}  
	@Test(timeout = 10000)
	public void isPositionNotRight(){
		assertEquals(false, c.isPositionNotRight(11));
		assertEquals(false, c.isPositionNotRight(3));
		assertEquals(false, c.isPositionNotRight(15));
		assertEquals(true, c.isPositionNotRight(14));
		assertEquals(true, c.isPositionNotRight(0));
	}
	@Test(timeout = 10000)
	public void isPositionNotTop(){
		assertEquals(true, c.isPositionNotTop(6));
		assertEquals(false, c.isPositionNotTop(0));
		assertEquals(false, c.isPositionNotTop(2));
		assertEquals(false, c.isPositionNotTop(3));
		assertEquals(true, c.isPositionNotTop(4));
		assertEquals(true, c.isPositionNotTop(15));
	}
	@Test(timeout = 10000)
	public void isPositionNotBottom(){
		assertEquals(true, c.isPositionNotBottom(11));
		assertEquals(true, c.isPositionNotBottom(0));
		assertEquals(false, c.isPositionNotBottom(15));
		assertEquals(false, c.isPositionNotBottom(12));
		assertEquals(false, c.isPositionNotBottom(13));;
	}
	
	@Test(timeout = 10000)
	public void getComponent(){
		assertEquals(false, c.getComponent(0,0) instanceof Component);
		assertEquals(false, c.getComponent(1,0) instanceof Component);
		assertEquals(true, c.getComponent(2,0) instanceof Component);
		assertEquals(true, c.getComponent(3,0) instanceof Component);
		assertEquals(false, c.getComponent(4,0) instanceof Component);
		assertEquals(false, c.getComponent(0,3) instanceof Component);
		assertEquals(true, c.getComponent(1,3) instanceof Component);
		assertEquals(false, c.getComponent(2,3) instanceof Component);
		assertEquals(true, c.getComponent(3,3) instanceof Component);
		assertEquals(false, c.getComponent(4,3) instanceof Component);
		assertEquals(true, c.getComponent(0,11) instanceof Component);
		assertEquals(true, c.getComponent(1,11) instanceof Component);
		assertEquals(false, c.getComponent(2,11) instanceof Component);
		assertEquals(true, c.getComponent(3,11) instanceof Component);
		assertEquals(false, c.getComponent(4,11) instanceof Component);
		assertEquals(true, c.getComponent(0,15) instanceof Component);
		assertEquals(true, c.getComponent(1,15) instanceof Component);
		assertEquals(false, c.getComponent(2,15) instanceof Component);
		assertEquals(false, c.getComponent(3,15) instanceof Component);
		assertEquals(false, c.getComponent(4,15) instanceof Component);
		
	}
	@Test(timeout = 10000)
	public void actionPerformedPauseIStart(){
		c.actionPerformed(new ActionEvent(c.getFooterPanel().getComponents()[0] , 5 , "PAUSE"));
		int pom = c.brojacSekundi().counter;
		try {Thread.sleep(1500);} catch (InterruptedException e) {}
		assertEquals(pom, c.brojacSekundi().counter);
		c.actionPerformed(new ActionEvent(c.getFooterPanel().getComponents()[0] , 5 , "START"));
		pom = c.brojacSekundi().counter;
		try {Thread.sleep(1500);} catch (InterruptedException e) {}
		assertEquals(pom+1, c.brojacSekundi().counter);
	}
	@Test(timeout = 10000)
	public void actionPerformedRestart(){
		c.actionPerformed(new ActionEvent(c.getFooterPanel().getComponents()[0] , 5 , "ReStart"));
		assertEquals(0, c.brojacSekundi().counter);
		assertEquals(false, c.dohvatiStatusIgre());
	}
	@Test(timeout = 10000)
	public void actionPerformedClose(){
		c.actionPerformed(new ActionEvent(c.getFooterPanel().getComponents()[0] , 5 , "CLOSE"));
		assertEquals(0, c.brojacSekundi().counter);
		assertEquals( null, c.brojacSekundi().timer_);
	}
	@Test(timeout = 10000)
	public void actionPerformedlevel(){
		c.actionPerformed(new ActionEvent(c.getFooterPanel().getComponents()[0] , 5 , "level1"));
		assertEquals(4, c.getLevel());
		
	}
	@Test(timeout = 10000)
	public void actionPerformedNumber(){
		int broj = c.nadjiPrazno(16);
		int br2 = 0;
		if(broj >8)
			br2 = broj-8;
		if(broj <=8)
			br2  = broj+8;
		
		c.actionPerformed(new ActionEvent(c.dohvatiButtonPanel(broj), 5 , "NUMBER"));
		assertEquals(broj, c.nadjiPrazno(16));
	}
	@Test(timeout = 10000)
	public void actionPerformedIns(){
		c.posaljiSignal(true);
		c.actionPerformed(new ActionEvent(c.dohvatiButtonPanel(1), 5 , "Instructions"));
		c.posaljiSignal(false);
		assertEquals(4, c.getLevel());
	}
	@Test(timeout = 10000)
	public void actionPerformedAbout(){
		c.posaljiSignal(true);
		c.actionPerformed(new ActionEvent(c.dohvatiButtonPanel(1), 5 , "About Shuffle"));
		c.posaljiSignal(false);
		assertEquals(false, c.dohvatiStatusIgre());
	}
	@Test(timeout = 10000)
	public void actionPerformedScore(){
		c.posaljiSignal(true);
		c.actionPerformed(new ActionEvent(c.dohvatiButtonPanel(1), 5 , "High Scores"));
		c.posaljiSignal(false);
	}
	
	@Test(timeout = 10000)
	public void actionPerformedNumber2(){
		int broj = c.nadjiPrazno(16);
		int br2 = 0;
		if(broj >8)
			br2 = broj-4;
		if(broj <=8)
			br2  = broj+4;
		
		c.actionPerformed(new ActionEvent(c.dohvatiButtonPanel(br2), 5 , "number"));
		assertEquals(4, c.getLevel());
	}
	@Test(timeout = 10000)
	public void showHighScoreDialog(){
		c.showHighScoreDialog();
		assertEquals(1000,c.brojacSekundi().timer_.getDelay());
	}
	@Test(timeout = 10000)
	public void showWarrningDialog(){
		c.showWarrningDialog();
		assertEquals(16,c.dohvatiBrojCelija());
	}
	@Test(timeout = 10000)
	public void showScoreDialog(){
		c.showScoreDialog(5,5);
		assertEquals(false, c.dohvatiStatusIgre());
		c.showScoreDialog(15,15);
	}
}
