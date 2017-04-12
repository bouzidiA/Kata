package com.tp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class BowlingTest {
	private BowlingCalcul bow;
    
    
    @Before
    public void setUp() {
    	bow = BowlingPartie.commencerPartie();
    }
    
    @Test
    public void testCasSansStrikeSpare() {
    	System.out.println("test");
    	bow.lancer(4);
    	bow.lancer(4);
        int score  = bow.sommePoint();
        Assert.assertEquals(8, score);

    }
    
    @Test
    public void testCasStrike() {
    	bow.lancer(10);
    	bow.lancer(0);
        int score  = bow.sommePoint();
        Assert.assertEquals(10, score);
        bow.lancer(5);
        bow.lancer(5);
        score  = bow.sommePoint();
        Assert.assertEquals(30, score);
    }
    
    @Test
    public void testCasStrike2() {
    	
    	bow.lancer(0);
    	bow.lancer(10);
        int score  = bow.sommePoint();
        Assert.assertEquals(10, score);
        bow.lancer(5);
        bow.lancer(4);
        score  = bow.sommePoint();
        Assert.assertEquals(28, score);
        bow.lancer(0);
    }

    @Test
    public void testCasSpare() {
        for (int i = 0; i < 10 ; i++) {
        	bow.lancer(4);
        	bow.lancer(6);
        }
        bow.lancer(5);
        int score = bow.sommePoint();
        Assert.assertEquals(15, score);
    }

    @Test
    public void testCasdernierStrike() {
        for (int i = 0; i < 10 ; i++) {
        	bow.lancer(10);
        	bow.lancer(0);
        }
        bow.lancer(3);
        bow.lancer(4);
        int score = bow.sommePoint();
        Assert.assertEquals(17, score);
    }

}
