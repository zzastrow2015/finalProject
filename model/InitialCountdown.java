package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

//Counts down the initial timer to determine when to start the game.
public class InitialCountdown extends JPanel{

	private int count;
	
	//starts countdown at 3.
	public InitialCountdown(){
		count = 3;
	}
	
	public void incrementCount(){
		count--;
	}
	
	public int getCount(){
		return count;
	}
}
