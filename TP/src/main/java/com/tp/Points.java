package com.tp;

public class Points {
	    private static final int MAX_LANCEE = 2;
		private static final int MAX_PINS = 0;
		private int[] scores = new int[MAX_LANCEE];
	    private int pins = 10;
	    private int attempts = 0;
	    private boolean isStrike = false;
	    int strikeCounter = 0;
	    
	    public boolean isSpare(){
	    	if(pins == 0 && attempts == MAX_LANCEE && !isStrike){
	    		return true;
	    	}else
	    		return false;
	    }
	    
	    public boolean isStrike(){
	    	if(pins == 0 && attempts == MAX_LANCEE && isStrike)
	    		return true;
	    	else
	    		return false;
	    }
	    
	    public boolean isDone(){
	    	if(attempts == MAX_LANCEE)
	    		return true;
	    	else
	    		return false;
	    }
	    
	    public void calculSomme(int score){
	     	System.out.println("score avant" + score);
	    	scores[attempts++] = score;
	    	pins -= score;
	    	System.out.println("score apres" + score);
	    	 if (score == MAX_PINS) {
	             isStrike = true;
	             strikeCounter++;
	         }
	    }
	    
	    public int resultat() { return scores[0] + scores[1];}

	    public int getPremierResultat() {
	        return scores[0];
	    }

	    public int getDeuxiemeResultat() {
	        return scores[1];
	    }
	    
	    public void limitAttempt(){
	        scores[1] = 0;
	        attempts++;
	    }

}
