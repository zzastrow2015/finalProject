package model;

public class Settings {

	public static int screenWidth = 400;
	public static int screenHeight = 400;
	
	public static int sizeX = screenWidth / 16;
	public static int sizeY = screenHeight / 16;

	private boolean limitedBorders;
	
	private int amountObstacles;
	
	private int delayTime;
	
	public Settings(String difficulty, boolean limitedBorders, boolean obstacles){
		delayTime = 120;
				
		if(difficulty.toUpperCase().equals("EASY")){
			delayTime = 120;
		}
		else if(difficulty.toUpperCase().equals("MEDIUM")){
			delayTime = 100;
		}
		else if(difficulty.toUpperCase().equals("HARD")){
			delayTime = 80;
		}
		else if(difficulty.toUpperCase().equals("VERY_HARD")){
			delayTime = 60;
		}
		
		this.limitedBorders = limitedBorders;
		amountObstacles = obstacles ? 10 : 0;
	}
	
	public int getDelayTime(){
		return delayTime;
	}
	
	public int getAmountObstacles(){
		return amountObstacles;
	}
	
	public boolean isBorderLimited(){
		return limitedBorders;
	}
	
}
