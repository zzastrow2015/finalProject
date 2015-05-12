package model;

public class Position { 
	
	  private int x; 
	  private int y; 
	  
	  //sets the initial position based on the x and y values that were passed when the object was created.
	  public Position(int x, int y) {
	    this.x = x; 
	    this.y = y; 
	  } 
	  
	  //changes the x and y values based on the parameters that are passed in.
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
