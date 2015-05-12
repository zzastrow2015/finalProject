package model;

import java.util.ArrayList;
import java.awt.Color;

public class GridSquares {

	int color;
	SquarePanel square;
	ArrayList<Color> C = new ArrayList<Color>();
	
	public GridSquares(int col){
		C.add(Color.black);  //snake
		C.add(Color.red);    //food
		C.add(Color.white);  //background
		C.add(Color.blue);  //wall
		
		color=col;
		square = new SquarePanel(C.get(color));
	}
	
	//sets the color of the object according to the color array list.
	public void setColor(int c){
		square.ChangeColor(C.get(c));
	}
	
	public SquarePanel getSquare() {
		return square;
	}
}
