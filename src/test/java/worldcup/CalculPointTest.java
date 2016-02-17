package worldcup;

import org.junit.Test;

import com.adif.model.Score;
import com.adif.service.PariService;
import static org.junit.Assert.*;

public class CalculPointTest {
	@Test
	public void testPoint(){
		PariService par = new PariService();
		Score score1 = new Score();
		score1.setButEquipe1(0);
		score1.setButEquipe2(0);
		Score score2 = new Score();
		score2.setButEquipe1(0);
		score2.setButEquipe2(0);
assertEquals(1, par.calculcoreExact(score1, score2));
	}
	
	@Test
	public void testPoint0(){
		PariService par = new PariService();
		Score score1 = new Score();
		score1.setButEquipe1(0);
		score1.setButEquipe2(1);
		Score score2 = new Score();
		score2.setButEquipe1(0);
		score2.setButEquipe2(0);
assertEquals(0, par.calculcoreExact(score1, score2));
	}
	
	@Test
	public void testPoint1(){
		PariService par = new PariService();
		Score score1 = new Score();
		score1.setButEquipe1(0);
		score1.setButEquipe2(2);
		Score score2 = new Score();
		score2.setButEquipe1(1);
		score2.setButEquipe2(3);
assertEquals(1, par.calculDiff(score1, score2));
	}
	
	@Test
	public void testPoint2(){
		PariService par = new PariService();
		Score score1 = new Score();
		score1.setButEquipe1(0);
		score1.setButEquipe2(2);
		Score score2 = new Score();
		score2.setButEquipe1(0);
		score2.setButEquipe2(3);
assertEquals(0, par.calculDiff(score1, score2));
	}
	
	@Test
	public void testPoint3(){
		PariService par = new PariService();
		Score score1 = new Score();
		score1.setButEquipe1(0);
		score1.setButEquipe2(2);
		Score score2 = new Score();
		score2.setButEquipe1(0);
		score2.setButEquipe2(3);
assertEquals(2, par.calculGagnant(score1, score2));
	}
	
	@Test
	public void testPoint4(){
		PariService par = new PariService();
		Score score1 = new Score();
		score1.setButEquipe1(0);
		score1.setButEquipe2(2);
		Score score2 = new Score();
		score2.setButEquipe1(2);
		score2.setButEquipe2(3);
assertEquals(2, par.calculGagnant(score1, score2));
	}
	@Test
	public void testPoint5(){
		PariService par = new PariService();
		Score score1 = new Score();
		score1.setButEquipe1(0);
		score1.setButEquipe2(0);
		Score score2 = new Score();
		score2.setButEquipe1(0);
		score2.setButEquipe2(0);
assertEquals(2, par.calculGagnant(score1, score2));
	}

}
