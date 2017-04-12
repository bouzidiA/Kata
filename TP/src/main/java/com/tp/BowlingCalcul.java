package com.tp;

import java.util.ArrayList;
import java.util.List;

public class BowlingCalcul implements BowlingImp{

	
	private final List<Points> points;
    private static final int MAX_FRAMES = 10;
    private static final int MAX_PINS = 10;
    public static final int MAX_ATTEMPTS = 2;
	private static final int STRIKE_SCORE = 0;
    private int frameCounter = 0;
    private int strikeCounter = 0;
	
	 public BowlingCalcul() {
		 points = new ArrayList<Points>(MAX_FRAMES);
	        for (int i = 0; i < MAX_FRAMES; i++) {
	        	points.add(new Points());
	        }
	    }
	 
	public void lancer(int numOfPins) {
		System.out.println("numOfPins" + numOfPins);
		if (numOfPins > MAX_PINS) {
           System.out.println("erreur");
        }
		Points point = getPoint();
		 if (points== null) {
			 System.out.println("erreur");
	        }
		 System.out.println("numOfPins2 " + numOfPins);
		 point.calculSomme(numOfPins);
		 System.out.println("numOfPins3 " + numOfPins);
		 if(isBonusFrame()){
			 Points prev = getPreviousFrame();
			 System.out.println("numOfPins4 " + numOfPins);
			 if (prev.isSpare()) {
				 System.out.println("numOfPins5 " + numOfPins);
	                point.limitAttempt();
	                System.out.println("numOfPins6 " + numOfPins);
	            }
		 }
			 
	}
	
	

	public int sommePoint() {
		int score;
		 if (frameCounter == 0) {
		        Points curr = getCurrentFrame();
		        return curr.resultat();
		 }else{
			 	if (isLastFrame() && isAllStrikes()) {
		            return STRIKE_SCORE;
		        }
		        Points curr = getCurrentFrame();
		        Points prev = getPreviousFrame();
		        if (isBonusFrame()) {
		            return prev.resultat() + curr.resultat();
		        }
		        score = curr.resultat();
		        if(prev.isSpare()) {
		            score += (prev.resultat() + curr.getPremierResultat());
		        }
		        if(prev.isStrike()) {
		            score += (prev.resultat() + curr.getPremierResultat() +  curr.getDeuxiemeResultat());
		        }
		 }
		 
		return score;
	}
	
	  private Points getPoint(){
		  Points point = getCurrentFrame();
		  System.out.println("points" + point);
	        if (point.isDone()) {
	                if(isLastFrame() && (point.isSpare() || point.isStrike())) {
	                Points bonus = new Points();
	                points.add(bonus);
	                frameCounter++;
	                return bonus;
	                }
	            frameCounter++;
	        if (frameCounter == MAX_FRAMES || isBonusFrame()) {
	                return null;
	            }
	            point = getCurrentFrame();
	        }
	        return point;
	    }
	  
	  
	  private Points getPreviousFrame() {
		    return points.get(frameCounter-1);
		}

		private Points getCurrentFrame() {
		    return points.get(frameCounter);
		}

		private boolean isAllStrikes() {
		return strikeCounter == MAX_FRAMES ;
		}

		private boolean isBonusFrame() {
			System.out.println("points.size() " + points.size());
		    return points.size() > MAX_FRAMES;
		}

		private boolean isLastFrame() {
		    return frameCounter == MAX_FRAMES - 1;
		}


}
