package model;

public class Position { 
	
	  private int x; 
	  private int y; 
	  
	  public Position(int x, int y) {
	    this.x = x; 
	    this.y = y; 
	  } 
	  
	  public void ChangeData(int x, int y){
		    this.x = x; 
		    this.y = y; 
	  }
	  
	  public int getX(){
		  return x;
	  }
	  
	  public int getY(){
		  return y;
	  }
} 